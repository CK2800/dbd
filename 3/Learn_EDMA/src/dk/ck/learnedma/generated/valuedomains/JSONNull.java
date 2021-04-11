package dk.ck.learnedma.generated.valuedomains;

import dk.ck.learnedma.generated.LearnEDMA;
import dk.ck.learnedma.generated.valuedomains.external.EDMA_ExternalConstraints;
import dk.ck.learnedma.generated.valuedomains.impl.JSONNullImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: JSONNull
 */
public abstract class JSONNull implements Comparable<JSONNull>
{
    protected static final IMetaValueDomain edma_domain = LearnEDMA.environment.getValueDomainDefinitions().getValueDomain(6);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The JSONNull from the terminal
     */
    public static JSONNull fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new JSONNullImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The JSONNull from the string representation
     */
    public static JSONNull fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new JSONNullImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The JSONNull read from the stream
     */
    public static JSONNull fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new JSONNullImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The JSONNull read from the stream
     */
    public static JSONNull fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new JSONNullImpl(res);
    }

    /**
     * Call this method to create a new JSONNull value. 
     * @param value  The value of the JSONNull to be created.
     * @return       The newly created JSONNull value
     */
    public static JSONNull create(String value) throws InvalidValueException
    {
        JSONNullImpl.edma_validate(value);
        return new JSONNullImpl(JSONNullImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided String is a valid JSONNull
     * @param value  The String value to be tested
     * @return       true if the provided String is a valid JSONNull
     */
    public static boolean isValidJSONNull(String value)
    {
        try
        {
            JSONNullImpl.edma_validate(value);
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
     * returns the String value that is stored in this JSONNull
     * @return  The String value stored in this JSONNull
     */
    public abstract String value();
}
