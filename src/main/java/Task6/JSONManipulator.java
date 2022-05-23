package Task6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONManipulator {
    public static String addId(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode tree;
        tree = mapper.readTree(json);
        if (tree.hasNonNull("info") && !tree.get("info").isValueNode() &&!tree.get("info").isArray()) {
            ((ObjectNode) tree.get("info")).put("id", 123);
        }
    
        return tree.toString();
    }
}
