/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.camel;

/**
 *
 * @author tnikolay
 */
public class TestCamel extends CamelTestSupport{
    
    
    public void testToFile() throws Exception {
        
    template.sendBody("direct:reports", "This is a great report");

    // give time for the file to be written before assertions
    Thread.sleep(1000);

    // assert the file exists
    File file = new File("target/test-reports/report.txt");
    file = file.getAbsoluteFile();
    assertTrue("The file should have been written", file.exists());
}

protected JndiRegistry createRegistry() throws Exception {
    // bind our processor in the registry with the given id
    JndiRegistry reg = super.createRegistry();
    reg.bind("processReport", new ProcessReport());
    return reg;
}

protected RouteBuilder createRouteBuilder() throws Exception {
    return new RouteBuilder() {
        public void configure() throws Exception {
            // the reports from the seda queue is processed by our processor
            // before they are written to files in the target/reports directory
            from("direct:reports").processRef("processReport").to("file://target/test-reports");
        }
    };
}

private class ProcessReport implements Processor {

    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        // do some business logic here

        // set the output to the file
        exchange.getOut().setBody(body);

        // set the output filename using java code logic, notice that this is done by setting
        // a special header property of the out exchange
        exchange.getOut().setHeader(FileComponent.HEADER_FILE_NAME, "report.txt");
    }

}
    
}
