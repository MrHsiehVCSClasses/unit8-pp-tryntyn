package u8pp;

public class Reservation{
    // Instance Variables of name of passenger and if frequent flyer
    private String name;
    private boolean frequentFlyer;

    //Constructors that takes the name of the passenger and the frequentFlyer status as parameters

         
        public Reservation(String tempName, boolean iffrequentFlyer)
        {
            this.name = tempName;
            this.frequentFlyer = iffrequentFlyer;
        }
    //Accessors methods named getPassengerName()that returns the passenger's name on the `Reservation`
    //An accessor method named isFrequentFlyer() that returns true if this passenger is a frequent flyer and `alse otherwise

        public String getPassengerName()
        {
            return this.name;
        }

        public boolean isFrequentFlyer()
        {
            if(this.frequentFlyer == true){
               return true; 
            }
            else{
                return false;
            }
        }

}