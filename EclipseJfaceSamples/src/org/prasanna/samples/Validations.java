package org.prasanna.samples;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Validations {
	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		createControlElements(shell);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();

	}
	
	public static void createControlElements(Shell parent){
		GridLayout gridLayout = new GridLayout(3, true);
		parent.setLayout(gridLayout);
		Label label = new Label(parent, SWT.NONE);
		label.setText("Please Enter Pincode:");
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		         
		Text  txtPincode = new Text(parent , SWT.NONE);
		txtPincode.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		         
		//Adding the decorator
		final ControlDecoration txtDecorator = new ControlDecoration(txtPincode, SWT.TOP|SWT.RIGHT);
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry .DEC_ERROR);
		Image img = fieldDecoration.getImage();
		txtDecorator.setImage(img);
		txtDecorator.setDescriptionText("Pls enter only numeric fields");
		// hiding it initially
		txtDecorator.hide();
		         
		txtPincode.addKeyListener(new KeyAdapter() {
		             
		  @Override
		 public void keyReleased(KeyEvent e) {
		     Text text = (Text)e.getSource();           
		     String string = text.getText();
		     char[] chars = new char[string.length()];
		     string.getChars(0, chars.length, chars, 0);
		      for (int i = 0; i < chars.length; i++)
		        {
		            if (!('0' <= chars[i] && chars[i] <= '9'))
		            {
		            txtDecorator.show();
		            }
		            else
		            {
		                txtDecorator.hide();
		            }
		 
		        }
		                
		}
		});
		
	}

}
