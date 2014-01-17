if (!$("#feed-generic").is(":checked")) {

    $("#feed-timeout-checkbox").parents('tr').hide();
    $("#feed-timeout-input-field").parents('tr').hide();
} else if ($("#feed-timeout-input-field").val() <= -1) {
    $("#feed-timeout-input-field").hide();
}

if (!$("#feed-timeout-checkbox").is(":checked")) {
    $("#feed-timeout-input-field").hide();
}

$("#feed-generic").on('click', function() {
    if (!$("#feed-generic").is(":checked")) {
        $("#feed-timeout-checkbox").parents('tr').hide();
        $("#feed-timeout-input-field").parents('tr').hide();
        $("#feed-timeout-checkbox").attr("checked", false);
        $("#feed-timeout-input-field").val("-1");
        $("#feed-timeout-input-field").hide();
    } else {
        $("#feed-timeout-checkbox").parents('tr').show();
        $("#feed-timeout-input-field").parents('tr').show();
    }
});

$("#feed-timeout-checkbox").on('click', function() {
    if (!$("#feed-timeout-checkbox").is(":checked")) {
        $("#feed-timeout-input-field").val("-1");
        $("#feed-timeout-input-field").hide();
    } else {
        alert('Please be careful. The stability of the system can not be guaranteed at excessive timeouts. It may happen that all applications on the feed Mobilizer backend no longer work.');
        $("#feed-timeout-input-field").show();
    }
});

$("#feed-timeout-input-field").on('click', function() {
    alert('Please be careful. The stability of the system can not be guaranteed at excessive timeouts. It may happen that all applications on the feed Mobilizer backend no longer work.');
});