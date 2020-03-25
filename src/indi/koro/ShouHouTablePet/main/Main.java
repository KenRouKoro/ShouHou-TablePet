/**
 * <p>文件名:Main.java</p>
 *
 * @author 16415
 * 创建时间：2019年7月29日 下午11:26:57
 */
package indi.koro.ShouHouTablePet.main;

import indi.koro.ShouHouTablePet.system.Pet;
import indi.koro.ShouHouTablePet.system.PetSystem;

/**
 *<p>项目名称：ShouHouTablePet</p>
 *<p>类名称:Main</p>
 * 作者： 16415
 * 版本：1.0
 *创建时间：2019年7月29日下午11:26:57
 *类描述:
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(String.valueOf(Pet.class.getResource("/file/cue/登录.wav")));
        PetSystem petSystem = new PetSystem();
        petSystem.load();
        petSystem.start();

    }
}
