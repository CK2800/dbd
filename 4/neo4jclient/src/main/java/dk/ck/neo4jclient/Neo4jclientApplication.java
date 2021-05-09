package dk.ck.neo4jclient;

import org.neo4j.driver.GraphDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Neo4jclientApplication
{
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(Neo4jclientApplication.class, args);
        try(Cyphers c = new Cyphers())
        {
            c.printGreeting("Gohejsasa");
        }


    }

}


