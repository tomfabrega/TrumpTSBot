import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 25.12.2016.
 */
public class BotSettings {

    private String bsp;
    final String sveinUId = "FiV9YrA+XrS9HGPLCBpfqbzayUs=";

    //Config for Testserver:
    private String username = "serveradmin";
    private String password = "LRc6aSGD";
    private String host = "localhost";
    private Integer serverId = 1;

    //Config for FF5-TS
   /*private String username = "SveinTSBot";
    private String password = "dyr98sss";
    private String host = "62.206.102.86";
    private Integer serverId = 2;*/


    //Einstellungen des Bots
    private String botUniqueId = "EBJJmWPjiWDv26gh0U+aqDKSjK8=";
    private String botname ="Config not loaded";
    private List<String> admins = new ArrayList<String>();
    private List<String> mods = new ArrayList<String>();
    private List<String> registeredUsers = new ArrayList<String>();



    private List<String> bekannteUser = new ArrayList<String>();
    private List<String> mexico = new ArrayList<String>();
    private Integer mauerCounter = 11;
    private Integer modus = 0;


    //Getter and Setter

    public List<String> getBekannteUser() {
        return bekannteUser;
    }

    public void setBekannteUser(List<String> bekannteUser) {
        this.bekannteUser = bekannteUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBsp() {
        return bsp;
    }

    public void setBsp(String bsp) {
        this.bsp = bsp;
    }

    public String getSveinUId() {
        return sveinUId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBotname() {
        return botname;
    }

    public void setBotname(String botname) {
        this.botname = botname;
    }

    public List<String> getAdmins() {
        return admins;
    }

    public void setAdmins(List<String> admins) {
        this.admins = admins;
    }

    public List<String> getMods() {
        return mods;
    }

    public void setMods(List<String> mods) {
        this.mods = mods;
    }

    public List<String> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(List<String> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public List<String> getMexico() {
        return mexico;
    }

    public void setMexico(List<String> mexico) {
        this.mexico = mexico;
    }

    public Integer getMauerCounter() {
        return mauerCounter;
    }

    public void setMauerCounter(Integer mauerCounter) {
        this.mauerCounter = mauerCounter;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getBotUniqueId() {
        return botUniqueId;
    }

    public void setBotUniqueId(String botUniqueId) {
        this.botUniqueId = botUniqueId;
    }
}
