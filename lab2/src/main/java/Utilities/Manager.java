
package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Manager {
    ExcelProvider provider = new ExcelProvider();
    
    public void Import(File file, String which, boolean a) throws IOException, FileNotFoundException, InvalidFormatException{
        Repository.getInstance().setMas(provider.readExcel(file,which,a));
    }
    
    public void Export() throws IOException{
        provider.writeExcel(Repository.getInstance().getMas());
    }
    
    public void Calculate(){
        Repository.getInstance().setParameters();
    }
}
