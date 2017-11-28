package Models;

public class InventaireSingleton {
	 private static Inventaire instance;
	    
	    private InventaireSingleton(){}
	    
	    //static block initialization for exception handling
	    static{
	        try{
	            instance = new Inventaire();
	        }catch(Exception e){
	            throw new RuntimeException("Exception occured in creating singleton instance");
	        }
	    }
	    
	    public static Inventaire getInstance(){
	        return instance;
	    }

}
