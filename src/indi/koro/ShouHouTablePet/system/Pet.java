/**
 *<p>文件名:Pet.java</p>
 * @author 16415
 *创建时间：2019年7月30日 下午9:17:41
 */
package indi.koro.ShouHouTablePet.system;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.w3c.dom.Element;

import indi.koro.ShouHouTablePet.xml.XmlUtils;


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
    String skin=new String();
    String file=new String();
    /**
     * 
     */
    public Pet(String file) {
	this.file=file;
	loadXML(file);
    }
    /**
     *<p>方法名：getFile</p>
     *说明：TODO
     */
    public String getFile() {
	return file;
    }
    /**
     *<p>方法名：getSkinHashMap</p>
     *说明：TODO
     */
    public HashMap<String, BufferedImage> getSkinHashMap() {
	return skinHashMap;
    }
    /**
     *<p>方法名：getSkin</p>
     *说明：TODO
     */
    public String getSkin() {
	return skin;
    }
    /**
     *<p>变量名：setSkin</p>
     *说明：TODO
     *
     */
    public void setSkin(String skin) {
	this.skin = skin;
    }
    /**
     *<p>方法名：getNameString</p>
     *说明：TODO
     */
    public String getNameString() {
	return nameString;
    }
    protected void loadXML(String file) {
	InputStream in=null;
	try {
	    in = new FileInputStream(new File(file+"/main.xml"));
	} catch (FileNotFoundException e1) {
	    // TODO 自动生成的 catch 块
	    e1.printStackTrace();
	}//Pet.class.getResourceAsStream(file+"/main.xml");
	Element root = XmlUtils.getRootElementFromStream(in);
	nameString= XmlUtils.getElementValue(root, "name"); 
	System.out.println(nameString);
	List<Element> skins=XmlUtils.getChildElements(root, "skin");
	boolean first=true;
	for (Element skinElement : skins) {
	    try {
		System.out.println(file+"/"+XmlUtils.getElementValue(skinElement, "file")+"/"+new File(file+"/"+XmlUtils.getElementValue(skinElement, "file")+"/").list()[0]);
		skinHashMap.put(XmlUtils.getElementValue(skinElement, "name"), ImageIO.read(new File(file+"/"+XmlUtils.getElementValue(skinElement, "file")+"/"+new File(file+"/"+XmlUtils.getElementValue(skinElement, "file")+"/").list()[0])));
		if (first) {
		    skin=XmlUtils.getElementValue(skinElement, "name");
		    first=false;
		}
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	    }
	}
    }
}
