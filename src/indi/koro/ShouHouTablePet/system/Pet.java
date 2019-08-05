/**
 *<p>文件名:Pet.java</p>
 * @author 16415
 *创建时间：2019年7月30日 下午9:17:41
 */
package indi.koro.ShouHouTablePet.system;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;


/**
 *<p>项目名称：ShouHouTablePet</p>
 *<p>类名称:Pet</p>
 * 作者： 16415
 * 版本：1.0
 *创建时间：2019年7月30日下午9:17:41
 *类描述:
 */
public class Pet {
    HashMap<String, BufferedImage> skinHashMap=new HashMap<>();
    String nameString=new String();
    
    /**
     * 
     */
    public Pet(File xmlFile) {
	loadXML();
    }
    protected void loadXML() {
	
    }
}
