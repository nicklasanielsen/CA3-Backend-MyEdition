package facades;

import DTOs.MyTimeStampDTO;
import DTOs.RandomFactDTO;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.MyTimeStamp;
import errorhandling.exceptions.FetchException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.HttpUtils;

/**
 *
 * @author Nicklas Nielsen
 */
public class MyEditionFacade {

    private static EntityManagerFactory emf;
    private static MyEditionFacade instance;

    private MyEditionFacade() {
        // Private constructor to ensure Singleton
    }

    public static MyEditionFacade getMyEditionFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MyEditionFacade();
        }

        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public MyTimeStampDTO getTimeStamp() {
        MyTimeStamp myTimeStamp = new MyTimeStamp();
        return new MyTimeStampDTO(myTimeStamp);
    }

    public RandomFactDTO getRandomFact() throws FetchException {
        String URL = "https://uselessfacts.jsph.pl/random.json?language=en";

        String json = HttpUtils.fetchData(URL);
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        RandomFactDTO randomFactDTO = new RandomFactDTO(jsonObject.get("text").getAsString());

        return randomFactDTO;
    }

}
