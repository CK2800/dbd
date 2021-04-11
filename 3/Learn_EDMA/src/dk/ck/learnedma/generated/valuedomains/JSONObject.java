package dk.ck.learnedma.generated.valuedomains;

import dk.ck.learnedma.generated.LearnEDMA;
import dk.ck.learnedma.generated.valuedomains.external.EDMA_ExternalConstraints;
import dk.ck.learnedma.generated.valuedomains.impl.JSONObjectImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: JSONObject
 */
public abstract class JSONObject implements Comparable<JSONObject>
{
    protected static final IMetaValueDomain edma_domain = LearnEDMA.environment.getValueDomainDefinitions().getValueDomain(1);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The JSONObject from the terminal
     */
    public static JSONObject fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new JSONObjectImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The JSONObject from the string representation
     */
    public static JSONObject fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new JSONObjectImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The JSONObject read from the stream
     */
    public static JSONObject fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new JSONObjectImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The JSONObject read from the stream
     */
    public static JSONObject fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new JSONObjectImpl(res);
    }

    /**
     * Call this method to create a new JSONObject value. 
     * @param value  The value of the JSONObject to be created.
     * @return       The newly created JSONObject value
     */
    public static JSONObject create(String value) throws InvalidValueException
    {
        JSONObjectImpl.edma_validate(value);
        return new JSONObjectImpl(JSONObjectImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided String is a valid JSONObject
     * @param value  The String value to be tested
     * @return       true if the provided String is a valid JSONObject
     */
    public static boolean isValidJSONObject(String value)
    {
        try
        {
            JSONObjectImpl.edma_validate(value);
        }
        catch(InvalidValueException e)
        {
            return false;
        }
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the String value that is stored in this JSONObject
     * @return  The String value stored in this JSONObject
     */
    public abstract String value();
}
