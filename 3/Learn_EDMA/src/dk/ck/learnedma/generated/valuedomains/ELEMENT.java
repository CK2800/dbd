package dk.ck.learnedma.generated.valuedomains;

import dk.ck.learnedma.generated.LearnEDMA;
import dk.ck.learnedma.generated.valuedomains.ELEMENTKey;
import dk.ck.learnedma.generated.valuedomains.ELEMENTValue;
import dk.ck.learnedma.generated.valuedomains.external.EDMA_ExternalConstraints;
import dk.ck.learnedma.generated.valuedomains.impl.ELEMENTBuilderImpl;
import dk.ck.learnedma.generated.valuedomains.impl.ELEMENTImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: ELEMENT
 */
public abstract class ELEMENT implements Comparable<ELEMENT>
{
    protected static final IMetaValueDomain edma_domain = LearnEDMA.environment.getValueDomainDefinitions().getValueDomain(11);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The ELEMENT from the terminal
     */
    public static ELEMENT fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new ELEMENTImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The ELEMENT from the string representation
     */
    public static ELEMENT fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new ELEMENTImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The ELEMENT read from the stream
     */
    public static ELEMENT fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new ELEMENTImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The ELEMENT read from the stream
     */
    public static ELEMENT fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new ELEMENTImpl(res);
    }

    /**
     * Starts creation of a new ELEMENT
     * @return  Builder interface to set the key field
     */
    public static ELEMENTBuilderKey create()
    {
        return new ELEMENTBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field key
     * @return  The value of the field key
     */
    public abstract ELEMENTKey key();

    /**
     * returns the value of the field value
     * @return  The value of the field value
     */
    public abstract ELEMENTValue value();


    /**
     * Builder interface for setting the key field of ELEMENT
     */
    public interface ELEMENTBuilderKey
    {

        /**
         * sets the key field.
         * @param key  The value to assign to the key field
         * @return     Builder interface for setting the value field
         */
        public ELEMENTBuilderValue key(ELEMENTKey key);

        /**
         * sets the key field.
         * @param key  The value to assign to the key field
         * @return     Builder interface for setting the value field
         */
        public ELEMENTBuilderValue key(String key) throws InvalidValueException;

    }



    /**
     * Builder interface for setting the value field of ELEMENT
     */
    public interface ELEMENTBuilderValue
    {

        /**
         * sets the value field.
         * @param value  The value to assign to the value field
         * @return       The created ELEMENT value
         */
        public ELEMENT value(ELEMENTValue value);

    }

}
