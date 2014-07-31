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
package org.camunda.spin.javascript.json.tree;

import org.camunda.spin.json.tree.JsonTreeMapObjectToJsonScriptTest;
import org.camunda.spin.test.ScriptEngine;
import org.junit.Ignore;

/**
 * Note: Jackson is apparently not able to map Nashorn's internal representations
 * of javascript objects and arrays.
 *
 * @author Thorben Lindhauer
 */
@Ignore
@ScriptEngine("javascript")
public class JsonTreeMapObjectToJsonJavascriptTest extends JsonTreeMapObjectToJsonScriptTest {

}