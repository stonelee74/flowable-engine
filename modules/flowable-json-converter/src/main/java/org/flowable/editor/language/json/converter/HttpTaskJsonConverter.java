/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.editor.language.json.converter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.flowable.bpmn.model.BaseElement;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.ServiceTask;

import java.util.Map;

/**
 * @author Tijs Rademakers
 */
public class HttpTaskJsonConverter extends BaseBpmnJsonConverter {

    public static void fillTypes(Map<String, Class<? extends BaseBpmnJsonConverter>> convertersToBpmnMap, Map<Class<? extends BaseElement>, Class<? extends BaseBpmnJsonConverter>> convertersToJsonMap) {

        fillJsonTypes(convertersToBpmnMap);
        fillBpmnTypes(convertersToJsonMap);
    }

    public static void fillJsonTypes(Map<String, Class<? extends BaseBpmnJsonConverter>> convertersToBpmnMap) {
        convertersToBpmnMap.put(STENCIL_TASK_HTTP, HttpTaskJsonConverter.class);
    }

    public static void fillBpmnTypes(Map<Class<? extends BaseElement>, Class<? extends BaseBpmnJsonConverter>> convertersToJsonMap) {
    }

    protected String getStencilId(BaseElement baseElement) {
        return STENCIL_TASK_HTTP;
    }

    protected void convertElementToJson(ObjectNode propertiesNode, BaseElement baseElement) {
        // done in service task
    }

    protected FlowElement convertJsonToElement(JsonNode elementNode, JsonNode modelNode, Map<String, JsonNode> shapeMap) {
        ServiceTask task = new ServiceTask();
        task.setType("http");
        addField("requestMethod", PROPERTY_HTTPTASK_REQ_METHOD, elementNode, task);
        addField("requestUrl", PROPERTY_HTTPTASK_REQ_URL, elementNode, task);
        addField("requestHeaders", PROPERTY_HTTPTASK_REQ_HEADERS, elementNode, task);
        addField("requestBody", PROPERTY_HTTPTASK_REQ_BODY, elementNode, task);
        addField("requestTimeout", PROPERTY_HTTPTASK_REQ_TIMEOUT, elementNode, task);
        addField("retryStatusCodes", PROPERTY_HTTPTASK_REQ_RETRY_STATUS_CODES, elementNode, task);
        addField("ignoreStatusCodes", PROPERTY_HTTPTASK_REQ_IGNORE_STATUS_CODES, elementNode, task);
        addField("variableNamePrefix", PROPERTY_HTTPTASK_VARIABLE_NAME_PREFIX, elementNode, task);
        return task;
    }
}
