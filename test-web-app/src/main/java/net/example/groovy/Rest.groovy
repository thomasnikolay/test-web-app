/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.example.groovy

import groovyx.net.http.RESTClient
 
def client = new RESTClient( 'http://www.acme.com/' )
def resp = client.get( path : 'products/3322' ) // ACME boomerang

assert resp.status == 200  // HTTP response code; 404 means not found, etc.
println resp.getData()
