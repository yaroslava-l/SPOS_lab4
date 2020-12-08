// The main MemoryManagement program, created by Alexander Reeder, 2000 Nov 19

import java.applet.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class MemoryManagement 
{
  public static void main(String[] args) 
  {
    ControlPanel controlPanel;
    Kernel kernel;

    String command = "commands";
    String memory = "memory.conf";

    File f = new File( command );

    if ( ! ( f.exists() ) ) 
    {
      System.out.println( "MemoryM: error, file '" + f.getName() + "' does not exist." );
      System.exit( -1 );
    }
    if ( ! ( f.canRead() ) ) 
    {
      System.out.println( "MemoryM: error, read of " + f.getName() + " failed." );
      System.exit( -1 );
    }

    if ( args.length == 2 ) 
    {
      f = new File( memory );

      if ( ! ( f.exists() ) ) 
      {
        System.out.println( "MemoryM: error, file '" + f.getName() + "' does not exist." );
        System.exit( -1 );
      }
      if ( ! ( f.canRead() ) ) 
      {
        System.out.println( "MemoryM: error, read of " + f.getName() + " failed." );
        System.exit( -1 );
      } 
    }

    kernel = new Kernel();
    controlPanel = new ControlPanel( "Memory Management" );
    if ( args.length == 1 ) 
    {
      controlPanel.init( kernel , command , null );
    }
    else
    {
      controlPanel.init( kernel , command , memory );
    }
  }
}
