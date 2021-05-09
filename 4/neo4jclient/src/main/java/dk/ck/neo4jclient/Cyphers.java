package dk.ck.neo4jclient;

import org.neo4j.driver.*;

import static org.neo4j.driver.Values.parameters;

public class Cyphers implements AutoCloseable
{
    private final Driver driver;

    public Cyphers()
    {
        driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "neo4j"));
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }
    // modificeret fra: https://neo4j.com/developer/java/
    public void printGreeting(final String message)
    {
        try( Session session = driver.session())
        {
            String greeting = session.writeTransaction(new TransactionWork<String>()
            {
                @Override
                public String execute(Transaction transaction)
                {
                    Result result = transaction.run("CREATE (a: Greeting) " +
                                                       "SET a.message=$message " +
                                                       "RETURN a.message + ' from node ' + id(a)",
                            parameters("message", message));
                    return result.single().get(0).asString();
                }
            });

            System.out.println(greeting);
        }
    }
}
