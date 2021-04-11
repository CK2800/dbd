package dk.ck.learnedma.generated.valuedomains;

import dk.ck.learnedma.generated.LearnEDMA;
import dk.ck.learnedma.generated.valuedomains.ELEMENTS;
import dk.ck.learnedma.generated.valuedomains.external.EDMA_ExternalConstraints;
import dk.ck.learnedma.generated.valuedomains.impl.JObjectBuilderImpl;
import dk.ck.learnedma.generated.valuedomains.impl.JObjectImpl;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.abstractica.edma.valuedomains.IMetaValueDomain;
import org.abstractica.edma.valuedomains.exceptions.InvalidValueException;
import org.abstractica.edma.valuedomains.userinput.ITerminal;
import org.abstractica.edma.valuedomains.userinput.ValueDomainInput;

/**
 * The representation of a value from the value domain: JObject
 */
public abstract class JObject implements Comparable<JObject>
{
    protected static final IMetaValueDomain edma_domain = LearnEDMA.environment.getValueDomainDefinitions().getValueDomain(12);



    /**
     * Get a value from a terminal
     * @param terminal  The terminal to get the value from
     * @return          The JObject from the terminal
     */
    public static JObject fromTerminal(ITerminal terminal)
    {
        ValueDomainInput vdi = new ValueDomainInput(terminal, EDMA_ExternalConstraints.instance);
        return new JObjectImpl(vdi.getValue(edma_domain));
    }

    /**
     * Get a value from its string representation
     * @param s  The String to parse
     * @return   The JObject from the string representation
     */
    public static JObject fromString(String s) throws InvalidValueException
    {
        Object res = edma_domain.valueFromString(s, EDMA_ExternalConstraints.instance);
        return new JObjectImpl(res);
    }

    /**
     * Reads and validates a value from a stream
     * @param in  A data input interface for the stream to read from
     * @return    The JObject read from the stream
     */
    public static JObject fromStream(DataInput in) throws IOException, InvalidValueException
    {
        Object res = edma_domain.readValue(in, EDMA_ExternalConstraints.instance);
        return new JObjectImpl(res);
    }

    /**
     * Reads a value from a stream without validating the value
     * @param in  A data input interface for the stream to read from
     * @return    The JObject read from the stream
     */
    public static JObject fromStreamNoValidate(DataInput in) throws IOException
    {
        Object res = edma_domain.readValueNoValidate(in);
        return new JObjectImpl(res);
    }

    /**
     * Starts creation of a new JObject
     * @return  Builder interface to set the elements field
     */
    public static JObjectBuilderElements create()
    {
        return new JObjectBuilderImpl();
    }



    /**
     * Writes this value to a stream
     * @param out  Interface to data output stream
     */
    public abstract void toStream(DataOutput out) throws IOException;

    /**
     * returns the value of the field elements
     * @return  The value of the field elements
     */
    public abstract ELEMENTS elements();


    /**
     * Builder interface for setting the elements field of JObject
     */
    public interface JObjectBuilderElements
    {

        /**
         * sets the elements field.
         * @param elements  The value to assign to the elements field
         * @return          The created JObject value
         */
        public JObject elements(ELEMENTS elements);

    }

}
