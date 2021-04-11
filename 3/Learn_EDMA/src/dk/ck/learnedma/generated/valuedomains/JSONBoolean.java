package dk.ck.learnedma.generated.valuedomains;

import dk.ck.learnedma.generated.LearnEDMA;
import dk.ck.learnedma.generated.valuedomains.external.EDMA_ExternalConstraints;
import dk.ck.learnedma.generated.valuedomains.impl.JSONBooleanImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: JSONBoolean
 */
public abstract class JSONBoolean implements Comparable<JSONBoolean>
{
    protected static final IMetaValueDomain edma_domain = LearnEDMA.environment.getValueDomainDefinitions().getValueDomain(5);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The JSONBoolean from the terminal
     */
    public static JSONBoolean fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new JSONBooleanImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The JSONBoolean from the string representation
     */
    public static JSONBoolean fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new JSONBooleanImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The JSONBoolean read from the stream
     */
    public static JSONBoolean fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new JSONBooleanImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The JSONBoolean read from the stream
     */
    public static JSONBoolean fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new JSONBooleanImpl(res);
    }

    /**
     * Call this method to create a new JSONBoolean value. 
     * @param value  The value of the JSONBoolean to be created.
     * @return       The newly created JSONBoolean value
     */
    public static JSONBoolean create(Boolean value)
    {
        return new JSONBooleanImpl(JSONBooleanImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Boolean is a valid JSONBoolean
     * @param value  The Boolean value to be tested
     * @return       true if the provided Boolean is a valid JSONBoolean
     */
    public static boolean isValidJSONBoolean(Boolean value)
    {
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the Boolean value that is stored in this JSONBoolean
     * @return  The Boolean value stored in this JSONBoolean
     */
    public abstract Boolean value();
}
