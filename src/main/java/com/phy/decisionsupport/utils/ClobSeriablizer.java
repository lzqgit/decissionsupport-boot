package com.phy.decisionsupport.utils;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

public class ClobSeriablizer extends JsonSerializer<Clob>
{
  public void serialize(Clob value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonProcessingException
  {
    if (value != null) {
      jgen.writeStartObject();
      try {
        Reader reader = value.getCharacterStream();
        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null)
        {
          sb.append(str);
        }
        jgen.writeString(sb.toString());
      } catch (SQLException e) {
        e.printStackTrace();
      }
      jgen.writeEndObject();
    }
  }
}