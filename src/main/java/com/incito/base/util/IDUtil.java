package com.incito.base.util;

import java.util.UUID;

/**
 * ID工具类，用于生成唯一标识
 * */
public class IDUtil {

  /**
   * 获取唯一标识UUID
   * */
  public static String getID() {
    UUID id = UUID.randomUUID();
    return id.toString().replaceAll("-", "");
  }

  public static UUID parseUUID(String id) {
    if (id.length() == 32) {
      String[] components = new String[5];
      components[0] = "0x" + id.substring(0, 8);
      components[1] = "0x" + id.substring(8, 12);
      components[2] = "0x" + id.substring(12, 16);
      components[3] = "0x" + id.substring(16, 20);
      components[4] = "0x" + id.substring(20);
      long mostSigBits = Long.decode(components[0]).longValue();
      mostSigBits <<= 16;
      mostSigBits |= Long.decode(components[1]).longValue();
      mostSigBits <<= 16;
      mostSigBits |= Long.decode(components[2]).longValue();

      long leastSigBits = Long.decode(components[3]).longValue();
      leastSigBits <<= 48;
      leastSigBits |= Long.decode(components[4]).longValue();

      return new UUID(mostSigBits, leastSigBits);
    }
    return UUID.fromString(id);
  }

}
