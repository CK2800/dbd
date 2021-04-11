package dk.ck.learnedma.generated.valuedomains;

import dk.ck.learnedma.generated.LearnEDMA;
import dk.ck.learnedma.generated.valuedomains.external.EDMA_ExternalConstraints;
import dk.ck.learnedma.generated.valuedomains.impl.ELEMENTKeyImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: ELEMENTKey
 */
public abstract class ELEMENTKey implements Comparable<ELEMENTKey>
{
    protected static final IMetaValueDomain edma_domain = LearnEDMA.environment.getValueDomainDefinitions().getValueDomain(7);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The ELEMENTKey from the terminal
     */
    public static ELEMENTKey fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new ELEMENTKeyImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The ELEMENTKey from the string representation
     */
    public static ELEMENTKey fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new ELEMENTKeyImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The ELEMENTKey read from the stream
     */
    public static ELEMENTKey fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new ELEMENTKeyImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The ELEMENTKey read from the stream
     */
    public static ELEMENTKey fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new ELEMENTKeyImpl(res);
    }

    /**
     * Call this method to create a new ELEMENTKey value. 
     * @param value  The value of the ELEMENTKey to be created.
     * @return       The newly created ELEMENTKey value
     */
    public static ELEMENTKey create(String value) throws InvalidValueException
    {
        ELEMENTKeyImpl.edma_validate(value);
        return new ELEMENTKeyImpl(ELEMENTKeyImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided String is a valid ELEMENTKey
     * @param value  The String value to be tested
     * @return       true if the provided String is a valid ELEMENTKey
     */
    public static boolean isValidELEMENTKey(String value)
    {
        try
        {
            ELEMENTKeyImpl.edma_validate(value);
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
     * returns the String value that is stored in this ELEMENTKey
     * @return  The String value stored in this ELEMENTKey
     */
    public abstract String value();
}
