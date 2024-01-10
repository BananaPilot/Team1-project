package Classes.User;

public class User {

    // inizializzazione id ed incremento
    private int userId;
    private static int staticUserId;

    private String userName;
    private String userSurname;

    /* i contatti dell'utente andranno dentro un arraylist
       il tipo di dato dovrà essere un oggetto contact
       contenente email, telefono e indirizzo
    */
    //private ArrayList<UserContacts> userContacts= new ArrayList<UserContacts>();

    // il nostro utente avrà come proprietà la mansione la data d'assunzione

    private String workingTask;
    // TODO private Date hiredDate;

    // proprietà per documentarne la fine del rapporto lavorativo

    private Boolean isFired = false;
    // TODO private Date dismissDate;

    /*
      proprietà per determinare la prestazione lavorativa giorno per giorno
      dovrà essere un oggetto che verrà istanziato giornalmente
      Times sarà il nome della sub classe per adesso
     */

    // TODO private Times dayPerformance;




}
