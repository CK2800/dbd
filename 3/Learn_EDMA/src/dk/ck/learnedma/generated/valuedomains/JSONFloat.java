package dk.ck.learnedma.generated.valuedomains;

import dk.ck.learnedma.generated.LearnEDMA;
import dk.ck.learnedma.generated.valuedomains.external.EDMA_ExternalConstraints;
import dk.ck.learnedma.generated.valuedomains.impl.JSONFloatImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: JSONFloat
 */
public abstract class JSONFloat implements Comparable<JSONFloat>
{
    protected static final IMetaValueDomain edma_domain = LearnEDMA.environment.getValueDomainDefinitions().getValueDomain(4);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The JSONFloat from the terminal
     */
    public static JSONFloat fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new JSONFloatImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The JSONFloat from the string representation
     */
    public static JSONFloat fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new JSONFloatImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The JSONFloat read from the stream
     */
    public static JSONFloat fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new JSONFloatImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The JSONFloat read from the stream
     */
    public static JSONFloat fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new JSONFloatImpl(res);
    }

    /**
     * Call this method to create a new JSONFloat value. 
     * @param value  The value of the JSONFloat to be created.
     * @return       The newly created JSONFloat value
     */
    public static JSONFloat create(Float value)
    {
        return new JSONFloatImpl(JSONFloatImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Float is a valid JSONFloat
     * @param value  The Float value to be tested
     * @return       true if the provided Float is a valid JSONFloat
     */
    public static boolean isValidJSONFloat(Float value)
    {
        return true;
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the Float value that is stored in this JSONFloat
     * @return  The Float value stored in this JSONFloat
     */
    public abstract Float value();
}
