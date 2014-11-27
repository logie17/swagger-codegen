package com.wordnik.swagger.codegen.languages;

import com.wordnik.swagger.codegen.*;
import com.wordnik.swagger.util.*;
import com.wordnik.swagger.models.Swagger;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class SwaggerGenerator extends DefaultCodegen implements CodegenConfig {

  public SwaggerGenerator() {
    super();
    outputFolder = "generated-code/swagger";
  }

  @Override
  public void processSwagger(Swagger swagger) {
    String swaggerString = Json.pretty(swagger);

    try{
      String outputFile = outputFolder + File.separator + "swagger.json";
      FileUtils.writeStringToFile(new File(outputFile), swaggerString);
      System.out.println("wrote file to " + outputFile);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}