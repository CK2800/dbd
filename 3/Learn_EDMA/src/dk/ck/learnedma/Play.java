package dk.ck.learnedma;

import dk.ck.learnedma.generated.valuedomains.*;

import java.util.Iterator;

public class Play
{
    public static void main(String[] args)
    {
        // Create John
        ELEMENT name = ELEMENT.create().key("name").value(ELEMENTValue.create(JSONString.create("John")));
        ELEMENT age = ELEMENT.create().key("age").value(ELEMENTValue.create(JSONNumber.create(34)));
        ELEMENTS johnsElements = ELEMENTS.begin().add(name).add(age).end();
        JObject john = JObject.create().elements(johnsElements);
        ELEMENT student = ELEMENT.create().key("student").value(ELEMENTValue.create(john));

        // Create Seahorse riding course
        ELEMENT sr_id = ELEMENT.create().key("id").value(ELEMENTValue.create(JSONNumber.create(1234)));
        ELEMENT sr_name = ELEMENT.create().key("name").value(ELEMENTValue.create(JSONString.create("Seahorse riding")));
        ELEMENT sr_ects = ELEMENT.create().key("ects").value(ELEMENTValue.create(JSONNumber.create(15)));
        ELEMENTS seahorseRidingElements = ELEMENTS.begin().add(sr_id).add(sr_name).add(sr_ects).end();
        JObject seahorseRiding = JObject.create().elements(seahorseRidingElements);

        // Create Squid painting course
        ELEMENT sp_id = ELEMENT.create().key("id").value(ELEMENTValue.create(JSONNumber.create(4321)));
        ELEMENT sp_name = ELEMENT.create().key("name").value(ELEMENTValue.create(JSONString.create("Squid painting")));
        ELEMENT sp_ects = ELEMENT.create().key("ects").value(ELEMENTValue.create(JSONNumber.create(5)));
        ELEMENTS squidPaintingElements = ELEMENTS.begin().add(sp_id).add(sp_name).add(sp_ects).end();
        JObject squidPainting = JObject.create().elements(squidPaintingElements);

        // Create list of courses.
        OBJECTS courseObjects = OBJECTS.begin().add(seahorseRiding).add(squidPainting).end();
        ELEMENT courses = ELEMENT.create().key("courses").value(ELEMENTValue.create(courseObjects));

        // Create boolean.
        ELEMENT active = ELEMENT.create().key("active").value(ELEMENTValue.create(JSONBoolean.create(true)));


        // Create parent element
        ELEMENTS parentElements = ELEMENTS.begin().add(student).add(courses).add(active).end();
        JObject parent = JObject.create().elements(parentElements);


        System.out.println(toString(parent, new StringBuilder()));

    }

    public static String toString(Object o, StringBuilder stringBuilder)
    {
        switch(o.getClass().getSuperclass().getSimpleName())
        {
            // simple typer
            case "JSONObject":
                stringBuilder.append("\"").append(((JSONObject) o).value()).append("\"");
                break;
            case "JSONString":
                stringBuilder.append("\"").append(((JSONString) o).value()).append("\"");
                break;
            case "JSONNull":
                stringBuilder.append("\"null\"");
                break;
            case "JSONNumber":
                stringBuilder.append(((JSONNumber) o).value());
                break;
            case "JSONFloat":
                stringBuilder.append(((JSONFloat) o).value());
                break;
            case "JSONBoolean":
                stringBuilder.append(((JSONBoolean) o).value().toString());
                break;


            case "JObject":
            {
                stringBuilder.append("{");
                // print elements
                toString(((JObject) o).elements(), stringBuilder);
                stringBuilder.append("}");
                break;
            }
            case "ELEMENTS":
            {
                Iterator<ELEMENT> iterator = ((ELEMENTS) o).iterator();
                while (iterator.hasNext())
                {
                    toString(iterator.next(), stringBuilder);
                    if (iterator.hasNext())
                        stringBuilder.append(",");
                }
                break;
            }
            case "OBJECTS":
            {
                stringBuilder.append("[");
                Iterator<JObject> iterator = ((OBJECTS) o).iterator();
                while (iterator.hasNext())
                {
                    toString(iterator.next(), stringBuilder);
                    if (iterator.hasNext())
                        stringBuilder.append(",");
                }
                stringBuilder.append("]");
                break;
            }
            case "ELEMENT":
            {
                ELEMENT element = ((ELEMENT) o);
                // print each key-value, iterate values if they are wrapped in JOBJECTS or JOBJECT

                toString(element.key(), stringBuilder);
                stringBuilder.append(":");
                toString(element.value(), stringBuilder);
                break;
            }
            case "ELEMENTKey":
            {
                stringBuilder.append("\"").append(((ELEMENTKey) o).value()).append("\"");
                break;
            }
            case "ELEMENTValue":
            {
                ELEMENTValue elementValue = (ELEMENTValue) o;
                if (elementValue.isJSONBoolean())
                    toString(elementValue.asJSONBoolean(), stringBuilder);
                else if (elementValue.isJSONNumber())
                    toString(elementValue.asJSONNumber(), stringBuilder);
                else if (elementValue.isJSONFloat())
                    toString(elementValue.asJSONFloat(), stringBuilder);
                else if (elementValue.isJSONString())
                    toString(elementValue.asJSONString(), stringBuilder);
                else if (elementValue.isJObject())
                    toString(elementValue.asJObject(), stringBuilder);
                else if (elementValue.isJSONNull())
                    toString(elementValue.asJSONNull(), stringBuilder);
                else if (elementValue.isOBJECTS())
                    toString(elementValue.asOBJECTS(), stringBuilder);
                break;
            }

            default:
            {
                stringBuilder.append("BURN");
                break;
            }
        }

        return stringBuilder.toString();
    }
}
