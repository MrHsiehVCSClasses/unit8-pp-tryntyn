package u8pp;

import java.util.ArrayList;

public class Flight
{

    private Reservation[][] reservations = null;
    //Constructors that takes integers of seats and rows
        // Forms a plane with reservations and aisles
        public Flight(int rows, int seats){
            if (seats % 2 == 0){
                int original = seats;
                seats += 1;
                reservations = new Reservation[rows][seats];
                for(int i = 0; i < reservations.length; i++){

                
                    reservations[i][(original/2)] = new Reservation("AISLE", false);
                }
            }
            else if(seats % 2 == 1){
              seats += 1;
                reservations = new Reservation[rows][seats];
                for(int i = 0; i < reservations.length; i++){
                    
                    reservations[i][((seats-1)/2)+1] = new Reservation("AISLE", false);
                }
            }
        }
    //Accessor
        //returns all tha passenger that are frequent flyers
        public ArrayList<String> getFrequentFlyers(){
          
            ArrayList<String> names = new ArrayList<String>();
          
            for(int i = 0; i < reservations.length; i++){
              for(int j = 0; j < reservations[0].length;j++){
                if(reservations[i][j] != null){
                  if(reservations[i][j].isFrequentFlyer() == true && reservations[i][j].getPassengerName().equals("AISLE")!= true){
                      names.add(reservations[i][j].getPassengerName());
                   }
                }
              }
            }
            return names;
        }  
    
    //Mutators that reserves the next open seats for the passenger
        //Reserves the next availiable seat 
        public boolean reserveNextAvailableSeat(String name, boolean freqFlyer){
             
              for(int i = 0; i < reservations.length; i++){
                  for(int j = 0; j < reservations[0].length; j++){
                    if(reservations[i][j] == null){
                      reservations[i][j] = new Reservation(name, freqFlyer);
                      return true;
                    }
                    
                  }
                }
              return false;
              }
        
            //Functions/Methods
            public boolean reserveAdjacentSeats(String passengerName, boolean firstFrequentFlyer, String passengerNameTwo, boolean secondFrequentFlyer){
              
              for(int i = 0; i < reservations.length;i++){
                for(int j = 0; j < reservations[0].length;j++){
                  if(j+1 < reservations[0].length){
                    if((reservations[i][j] == null)&&(reservations[i][j+1] == null)){
                      reservations[i][j] = new Reservation(passengerName,firstFrequentFlyer);
                      reservations[i][j+1] = new Reservation(passengerNameTwo,secondFrequentFlyer);
                     return true;
                    }
                  }
                }
              }
            return false;  
            }
    
    public boolean reserveWindowSeat(String name, boolean freqFlyer){
      int Last = reservations[0].length -1;
        int First = 0;
      
      for(int i = 0; i < reservations.length; i ++){
        if(reservations[i][First] == null){
          reservations[i][First] = new Reservation(name, freqFlyer);
         return true;
          
        }
        else if (reservations[i][Last] == null){
          reservations[i][Last] = new Reservation(name, freqFlyer);
          return true;
        }
        
      }
   return false;   
    }

      

            public boolean reserveAisleSeat(String name, boolean freqFlyer){
              int left = 0;
              int right = 0;
                for(int i = 0; i < reservations[0].length; i++){
                  if(reservations[0][i] != null){
                      if(reservations[0][i].getPassengerName().equals("AISLE")){
                        left = i - 1;
                        right = i + 1;
                        break;
                      }
                    }
                  }
                  for(int j = 0; j < reservations.length; j++){ 
                    if(reservations[j][left] == null){
                        reservations[j][left] = new Reservation(name, freqFlyer);
                      return true;
                      }
                    else if(reservations[j][right] == null){
                        reservations[j][right] = new Reservation(name, freqFlyer);
                      return true;
                      }
                    
                    }
                  return false;
                  }


  
                
            
                public ArrayList<String> getIsolatedPassengers(){
                    ArrayList<String> nameList = new ArrayList<String>();

                    for(int i = 0; i < reservations.length; i++){
                      for(int j = 0; j < reservations[0].length; j++){
                      if(reservations[i][j] != null){
                        if(reservations[i][j].getPassengerName().equals("AISLE") != true ){
                          if(leftEmpty(i,j) == true && rightEmpty(i,j) == true){
                            nameList.add(reservations[i][j].getPassengerName());
                        }
                      }
                    }
                  }
                  
                     
                    }
                  return nameList;
                  }




  
  public String toString(){
    String planeList = "";
    for(int i = 0; i < reservations.length; i++){
      
      for(int j = 0; j < reservations[0].length; j++){
        
          if(reservations[i][j] != null){
            if(reservations[i][j].getPassengerName().equals("AISLE")){
              
            
            planeList += "AISLE";
            
              if((j + 1) < reservations[0].length){
                
                planeList += " ";
                
                }
            }
          }
        if(reservations[i][j] != null){
          if(reservations[i][j].getPassengerName().equals("AISLE") == false){
          planeList += reservations[i][j].getPassengerName();
            if((j + 1) < reservations[0].length){
              planeList += " ";
            }  
            }
        }
        else if(reservations[i][j] == null){
          planeList += "EMPTY";
          if((j + 1) < reservations[0].length){
            planeList += " ";
          }
        
        }
      }
      if((i + 1) < reservations.length){
        planeList += "\n";
      }
    }
    return planeList;
  }
                
  public Reservation[][] getSeats(){
    return reservations;
      
    }
  public boolean leftEmpty(int r, int c){
    if((c - 1) >= 0 ){
      if(reservations[r][c-1] != null){
        if(reservations[r][c-1].getPassengerName().equals("AISLE")){
          return true;
        }
        else{
          return false;
        }
      }
      else{
      return true;  
      }
    }
    return true;
    }
  public boolean rightEmpty(int r, int c){
    if((c + 1) < reservations[0].length ){
      if(reservations[r][c+1] != null){
        if(reservations[r][c+1].getPassengerName().equals("AISLE")){
          return true;
        }
        else{
          return false;
        }
      }
      else{
      return true;  
      }
    }
    return true;
  }
}
      
