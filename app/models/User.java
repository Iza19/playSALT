package models;

import com.google.code.morphia.annotations.Entity;
import org.hibernate.validator.constraints.Email;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.modules.morphia.Model;
import java.util.Random;
import play.libs.Crypto;
import java.lang.Math;
import flexjson.JSONSerializer;

import static play.libs.F.Matcher.String;

/**
 * Created by iza on 7/11/16.
 */

@Entity
public class User extends Model {

    @Required
    @Email
    public String email;

    // Peanut = Secret key for "password"
    @Required
    @MinSize(6)
    public String peanut;

    public String saltKey;

    public void encriptarPassword() {
        long dig13 = new Random().nextLong() + 1000000000000L;
        final int saltKeyLength = 16;
        this.saltKey = Crypto.passwordHash("100000000o0iuy78").substring(0, 16);
        if (this.peanut == null) {
            //Regresa error
        } else {
            this.peanut = Crypto.encryptAES(this.peanut, this.saltKey);
        }
    }

    public boolean compararPassword(String otherPass) {
        return this.peanut.equals(Crypto.encryptAES(otherPass, this.saltKey));
    }

    public static JSONSerializer serializador() {
        JSONSerializer seria = new JSONSerializer();
        seria.include("*.email");
        return seria;
    }
}
