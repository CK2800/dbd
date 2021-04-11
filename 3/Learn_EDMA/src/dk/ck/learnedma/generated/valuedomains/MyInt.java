package dk.ck.learnedma.generated.valuedomains;

import dk.ck.learnedma.generated.LearnEDMA;
import dk.ck.learnedma.generated.valuedomains.external.EDMA_ExternalConstraints;
import dk.ck.learnedma.generated.valuedomains.impl.MyIntImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: MyInt
 */
public abstract class MyInt implements Comparable<MyInt>
{
    protected static final IMetaValueDomain edma_domain = LearnEDMA.environment.getValueDomainDefinitions().getValueDomain(0);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The MyInt from the terminal
     */
    public static MyInt fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new MyIntImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The MyInt from the string representation
     */
    public static MyInt fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new MyIntImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The MyInt read from the stream
     */
    public static MyInt fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new MyIntImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The MyInt read from the stream
     */
    public static MyInt fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new MyIntImpl(res);
    }

    /**
     * Call this method to create a new MyInt value. 
     * @param value  The value of the MyInt to be created.
     * @return       The newly created MyInt value
     */
    public static MyInt create(Integer value) throws InvalidValueException
    {
        MyIntImpl.edma_validate(value);
        return new MyIntImpl(MyIntImpl.edma_create(value));
    }

    /**
     * Call this method to test if the provided Integer is a valid MyInt
     * @param value  The Integer value to be tested
     * @return       true if the provided Integer is a valid MyInt
     */
    public static boolean isValidMyInt(Integer value)
    {
        try
        {
            MyIntImpl.edma_validate(value);
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
     * returns the Integer value that is stored in this MyInt
     * @return  The Integer value stored in this MyInt
     */
    public abstract Integer value();
}
