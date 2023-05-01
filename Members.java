package virtualLibrary;

public class Members {
  //attributes
    protected String name;
    protected String memberAddress;
    protected String phone;
    
    
    //default constructor
    public Members() {
        name = "";
        memberAddress = "";
        phone = "";
    }

    //Non-default Constructor
    public Members (String accountName, String address, String phoneNumber) {
        name = accountName;
        memberAddress = address;
        phone = phoneNumber;
    }

    //Set Methods
    public void setName (String name) {
        this.name = name;
    }
    
    public void setMemberAddress (String memberAddress) {
        this.memberAddress = memberAddress;
    }
    
    public void setPhone (String phone) {
        this.phone = phone;
    }
    
    
    //Get Methods
    public String getName () {
        return this.name;
    }
    
    public String getMemberAddress () {
        return this.memberAddress;
    }
    
    public String getPhone () {
        return this.phone;
    }
   
}
