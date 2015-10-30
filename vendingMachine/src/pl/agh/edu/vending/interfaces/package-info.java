/**
 * pl.agh.edu.vending.interfaces contains interfaces for particular components of of vending machine
 * I separated five main parts, those are:
 * <ul>
 * 	<li><b>Cashier</b>: manage money during transaction</li>
 * 	<li><b>Deposit</b>: manage all money in the machine</li>
 * 	<li><b>Storage</b>: manage products(price, availability etc)</li>
 * 	<li><b>UserInput</b>: gets input from user and process it into requests</li>
 * 	<li><b>UserOutput</b>: displays what the client should see</li>
 * </ul>
 * 
 * Those five components implemented properly(that is using provided interfaces) can successfully
 * manage interaction with client. There is no administrative interaction like adding products etc.
 * For simulation purpose  products have to be somehow given in class implementing storage interface
 * (Array, List, etc)  
 */
package pl.agh.edu.vending.interfaces;