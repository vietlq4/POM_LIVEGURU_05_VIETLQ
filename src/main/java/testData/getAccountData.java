package testData;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class getAccountData {

    public static getAccountData get(String filename)  throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), getAccountData.class);
    }
    @JsonProperty("userName")
    String userName;

    @JsonProperty("password")
     String password;

    @JsonProperty("mobileX")
    MobileX mobileX;





    public String getuserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

    public String getname() {
         return mobileX.name;
    }
    public String getPrice() {
        return mobileX.price;
    }



//    public String getCCState() {
//        return cc.state;
//    }
//    public String getNumbPin() {
//        return numb.pin;
//    }
//    public String getNumbMobile() {
//        return numb.mobile;
    static class MobileX {
        @JsonProperty("name")
        String name;

        @JsonProperty("price")
        String price;
    }

}
