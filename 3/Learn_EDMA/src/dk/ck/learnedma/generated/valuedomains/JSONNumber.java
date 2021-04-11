package dk.ck.learnedma.generated.valuedomains;

import dk.ck.learnedma.generated.LearnEDMA;
import dk.ck.learnedma.generated.valuedomains.external.EDMA_ExternalConstraints;
import dk.ck.learnedma.generated.valuedomains.impl.JSONNumberImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: JSONNumber
 */
public abstract class JSONNumber implements Comparable<JSONNumber>
{
    protected static final IMetaValueDomain edma_domain = LearnEDMA.environment.getValueDomainDefinitions().getValueDomain(3);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The JSONNumber from the terminal
     */
    public static JSONNumber fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new JSONNumberImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The JSONNumber from the string representation
     */
    public static JSONNumber fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new JSONNumberImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The JSONNumber read from the stream
     */
    public static JSONNumber fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new JSONNumberImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The JSONNumber read from the stream
     */
    public static JSONNumber fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new JSONNumberImpl(res);
    }

    /**
     * Call this method to create a new JSONNumber value. 
     * @param value  The value of the JSONNumber to be created.
     * @return       The newly created JSONNumber value
     */
    public static JSONNumber create(Integer value)
    {
        return new JSONNumberImpl(JSONNumberImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid JSONNumber
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid JSONNumber
     */
    public static boolean isValidJSONNumber(Integer value)
    {
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the Integer value that is stored in this JSONNumber
     * @return  The Integer value stored in this JSONNumber
     */
    public abstract Integer value();
}
