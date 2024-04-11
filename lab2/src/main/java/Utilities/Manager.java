
package Utilities;

import Utilities.Repository;
import java.io.IOException;

public class Manager {
    ExcelProvider provider = new ExcelProvider();
    
    public void Import(String which, boolean a) throws IOException{
        Repository.getInstance().setMas(provider.readExcel(which,a));
    }
    
    public void Export() throws IOException{
        provider.writeExcel(Repository.getInstance().getMas());
    }
    
    public void Calculate(){
        Repository.getInstance().setParameters();
    }
}
