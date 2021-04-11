package dk.ck.learnedma.generated;

import java.util.ArrayList;
import java.util.Collection;
import org.abstractica.edma.metamodel.IMetaEnvironment;
import org.abstractica.edma.metamodel.impl.MetaEnvironment;
import org.abstractica.edma.metamodel.impl.ValueDomainBuilder;
import org.abstractica.edma.metamodel.impl.ValueDomainBuilder.Field;
import org.abstractica.edma.runtime.implementations.mem.modelstore.speed.newindex.IndexUtil;
import org.abstractica.edma.runtime.intf.IRuntimeFactory;
import org.abstractica.edma.valuedomains.impl.Constraint;

/**
 * 
 */
public class LearnEDMA
{
    public static final IMetaEnvironment environment = generateEnvironment();



    /**
     * generate the environment
     * @return  
     */
    public static IMetaEnvironment generateEnvironment()
    {
        ValueDomainBuilder vdb = new ValueDomainBuilder();
        
        //Integer value domain: MyInt
        {
            ArrayList<Constraint> edma_constraints = new ArrayList<Constraint>(1);
            edma_constraints.add(new Constraint("isEven", "No description given"));
            vdb.newIntegerDomain("MyInt", null, 1, 42, edma_constraints, false);
        }
        
        //String value domain: JSONObject
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("JSONObject", null, 1, null, null, edma_constraints, false);
        }
        
        //String value domain: JSONString
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("JSONString", null, null, null, null, edma_constraints, false);
        }
        
        //Integer value domain: JSONNumber
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("JSONNumber", null, null, null, edma_constraints, false);
        }
        
        //Float value domain: JSONFloat
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newFloatDomain("JSONFloat", null, null, null, edma_constraints, false);
        }
        
        //Boolean value domain: JSONBoolean
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newBooleanDomain("JSONBoolean", null, edma_constraints, false);
        }
        
        //String value domain: JSONNull
        {
            ArrayList<Constraint> edma_constraints = new ArrayList<Constraint>(1);
            edma_constraints.add(new Constraint("isNull", "No description given"));
            vdb.newStringDomain("JSONNull", null, 4, 4, null, edma_constraints, false);
        }
        
        //String value domain: ELEMENTKey
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("ELEMENTKey", null, 1, null, null, edma_constraints, false);
        }
        
        //OneOf value domain: ELEMENTValue
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<String> optionDomains = new ArrayList<String>(7);
            optionDomains.add("OBJECTS");
            optionDomains.add("JObject");
            optionDomains.add("JSONString");
            optionDomains.add("JSONNumber");
            optionDomains.add("JSONFloat");
            optionDomains.add("JSONBoolean");
            optionDomains.add("JSONNull");
            vdb.newOneOfDomain("ELEMENTValue", null, optionDomains, edma_constraints, false);
        }
        
        //List value domain: ELEMENTS
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newListDomain("ELEMENTS", null, "ELEMENT", null, null, edma_constraints, false);
        }
        
        //List value domain: OBJECTS
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newListDomain("OBJECTS", null, "JObject", null, null, edma_constraints, false);
        }
        
        //Struct value domain: ELEMENT
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("key", "ELEMENTKey", false));
            fields.add(vdb.newStructField("value", "ELEMENTValue", false));
            vdb.newStructDomain("ELEMENT", null, fields, edma_constraints, false);
        }
        
        //Struct value domain: JObject
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("elements", "ELEMENTS", false));
            vdb.newStructDomain("JObject", null, fields, edma_constraints, false);
        }
        MetaEnvironment edma_environment = new MetaEnvironment("LearnEDMA");
        vdb.buildWithEnvironment(edma_environment);
        //Hack to make serializeable work...
        IndexUtil.setValueDomainDefinitions(edma_environment.getValueDomainDefinitions());
        return edma_environment;
    }

    /**
     * Constructor
     * @param factory  The runtime factory
     */
    public LearnEDMA(IRuntimeFactory factory)
    {
        
    }
}
