package com.apress.javapersist.chapter06.bo;

import java.util.Date;

/**
 *  Description of the Class
 *
 *@author     rsperko
 *@created    March 20, 2002
 */
public class Employee {
  private String guid;
  private String firstName;
  private String lastName;
  private int numDependants;
  private Date dateOfBirth;
  private boolean employed;


  /**
   *  Sets the employed attribute of the Employee object
   *
   *@param  employed  The new employed value
   *@since
   */
  public void setEmployed( boolean employed ) {
    this.employed = employed;
  }



  /**
   *  Sets the guid attribute of the Employee object
   *
   *@param  guid  The new guid value
   *@since
   */
  public void setGuid( String guid ) {
    this.guid = guid;
  }


  /**
   *  Sets the firstName attribute of the Employee object
   *
   *@param  firstName  The new firstName value
   *@since
   */
  public void setFirstName( String firstName ) {
    this.firstName = firstName;
  }


  /**
   *  Sets the lastName attribute of the Employee object
   *
   *@param  lastName  The new lastName value
   *@since
   */
  public void setLastName( String lastName ) {
    this.lastName = lastName;
  }


  /**
   *  Sets the numDependants attribute of the Employee object
   *
   *@param  numDependants  The new numDependants value
   *@since
   */
  public void setNumDependants( int numDependants ) {
    this.numDependants = numDependants;
  }


  /**
   *  Sets the dateOfBirth attribute of the Employee object
   *
   *@param  dateOfBirth  The new dateOfBirth value
   *@since
   */
  public void setDateOfBirth( Date dateOfBirth ) {
    this.dateOfBirth = dateOfBirth;
  }


  /**
   *  Gets the employed attribute of the Employee object
   *
   *@return    The employed value
   *@since
   */
  public boolean getEmployed() {
    return employed;
  }


  /**
   *  Gets the guid attribute of the Employee object
   *
   *@return    The guid value
   *@since
   */
  public String getGuid() {
    return guid;
  }


  /**
   *  Gets the firstName attribute of the Employee object
   *
   *@return    The firstName value
   *@since
   */
  public String getFirstName() {
    return firstName;
  }


  /**
   *  Gets the lastName attribute of the Employee object
   *
   *@return    The lastName value
   *@since
   */
  public String getLastName() {
    return lastName;
  }


  /**
   *  Gets the numDependants attribute of the Employee object
   *
   *@return    The numDependants value
   *@since
   */
  public int getNumDependants() {
    return numDependants;
  }


  /**
   *  Gets the dateOfBirth attribute of the Employee object
   *
   *@return    The dateOfBirth value
   *@since
   */
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

}

