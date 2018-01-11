package edu.fudan.ringbell;

import org.junit.Assert;
import org.junit.Test;

import edu.fudan.ringbell.http.UserRequest;

/**
 * Created by pc on 2018/1/11.
 */

public class UserRequestTest {

    @Test
    public void testRegister() {
        int i = UserRequest.register("aaaaaa394978", "testpassword", "aaaaaa394978");
        Assert.assertEquals(0,i);
        System.out.println(i);
    }

    @Test
    public void testLogin() {
        int i = UserRequest.login("aaaaaa394978", "testpassword");
        System.out.println(i);
        Assert.assertEquals(0,i);
    }

    @Test
    public void testModify() {
        UserRequest.login("aaaaaa394978", "testpassword");
        int i = UserRequest.modify("testpassword", "testnewpwd");
        Assert.assertEquals(0,i);
    }
}
