package org.ideademo.epiko.pages.dap;

import org.hibernate.Session;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import org.apache.tapestry5.ioc.annotations.Inject;

import org.ideademo.epiko.entities.Dap;
import org.ideademo.epiko.pages.Daps;


public class UpdateDap
{
	
  @Inject
  private Session session;
  
  @PageActivationContext 
  @Property
  private Dap dap;
  
  @InjectPage
  private Daps daps;
  
  
  Object onSelectedFromSearch() 
  {
	daps.setDapExample(dap);
    return daps;
  }
  
  
  @CommitAfter
  Object onSuccess()
  {
   session.saveOrUpdate(dap);
   return daps;
  }
  
  void onPrepareForRender()  {if(this.dap == null){this.dap = new Dap();}}
  void onPrepareForSubmit()  {if(this.dap == null){this.dap = new Dap();}}
}
