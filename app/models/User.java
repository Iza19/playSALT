package models;


import play.*;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.*;
import javax.persistence.*;
import java.util.*;

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
    @MaxSize(1000)
    public String peanut;
}
