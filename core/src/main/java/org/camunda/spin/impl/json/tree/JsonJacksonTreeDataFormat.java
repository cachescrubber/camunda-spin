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
package org.camunda.spin.impl.json.tree;

import java.util.Map;

import org.camunda.spin.json.SpinJsonNode;
import org.camunda.spin.spi.DataFormat;
import org.camunda.spin.spi.DataFormatReader;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Thorben Lindhauer
 */
public class JsonJacksonTreeDataFormat implements DataFormat<SpinJsonNode>, JsonJacksonTreeConfigurable<JsonJacksonTreeDataFormat> {

  public static final JsonJacksonTreeDataFormat INSTANCE = new JsonJacksonTreeDataFormat();
  
  protected JsonJacksonTreeConfiguration configuration;
  
  public JsonJacksonTreeDataFormat() {
    this.configuration = new JsonJacksonTreeConfiguration();
  }
  
  public Class<? extends SpinJsonNode> getWrapperType() {
    return SpinJsonJacksonTreeNode.class;
  }

  public SpinJsonNode createWrapperInstance(Object parameter) {
    return new SpinJsonJacksonTreeNode((JsonNode) parameter);
  }

  public String getName() {
    return "application/json; implementation=tree";
  }
  
  // configuration


  public JsonJacksonTreeDataFormat newInstance() {
    JsonJacksonTreeDataFormat instance = new JsonJacksonTreeDataFormat();
    instance.configuration = 
        new JsonJacksonTreeConfiguration(configuration);
    
    return instance;
  }


  public JsonJacksonTreeDataFormat config(String key, Object value) {
    configuration.config(key, value);
    return this;
  }
  
  public JsonJacksonTreeDataFormat config(Map<String, Object> config) {
    configuration.config(config);
    return this;
  }

  public Object getValue(String key) {
    return configuration.getValue(key);
  }

  public Object getValue(String key, Object defaultValue) {
    return configuration.getValue(key, defaultValue);
  }

  public Boolean allowsNumericLeadingZeros() {
    return configuration.allowsNumericLeadingZeros();
  }

  public JsonJacksonTreeDataFormat allowNumericLeadingZeros(Boolean value) {
    configuration.allowNumericLeadingZeros(value);
    return this;
  }

  public Map<String, Object> getConfiguration() {
    return configuration.getConfiguration();
  }
  
  public DataFormatReader getReader() {
    return new JsonJacksonTreeDataFormatReader(this);
  }

  public Boolean allowsComments() {
    return configuration.allowsComments();
  }

  public JsonJacksonTreeDataFormat allowComments(Boolean value) {
    configuration.allowComments(value);
    return this;
  }

  public Boolean allowsUnquotedFieldNames() {
    return configuration.allowsUnquotedFieldNames();
  }

  public JsonJacksonTreeDataFormat allowQuotedFieldNames(Boolean value) {
    configuration.allowQuotedFieldNames(value);
    return this;
  }

  public Boolean allowsSingleQuotes() {
    return configuration.allowsSingleQuotes();
  }

  public JsonJacksonTreeDataFormat allowSingleQuotes(Boolean value) {
    configuration.allowSingleQuotes(value);
    return this;
  }

  public Boolean allowsBackslashEscapingAnyCharacter() {
    return configuration.allowsBackslashEscapingAnyCharacter();
  }

  public JsonJacksonTreeDataFormat allowBackslashEscapingAnyCharacter(Boolean value) {
    configuration.allowBackslashEscapingAnyCharacter(value);
    return this;
  }

  public Boolean allowsNonNumericNumbers() {
    return configuration.allowsNonNumericNumbers();
  }

  public JsonJacksonTreeDataFormat allowNonNumericNumbers(Boolean value) {
    configuration.allowNonNumericNumbers(value);
    return this;
  }

}