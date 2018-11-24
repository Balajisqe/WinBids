package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Property {
	static Properties props = new Properties();
	String strFile;
	String strVal;

	public Property(String strFile)
	{
		this.strFile = strFile;
	}	
	public String getProperty(String str)
	{
		try
		{
			File f = new File(strFile);
			if (f.exists())
			{
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				strVal = props.getProperty(str);
				in.close();
			}
			else
				System.out.println("File not found!");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return strVal;
	}


}
