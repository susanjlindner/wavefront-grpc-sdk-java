package com.wavefront.sdk.grpc;

import io.grpc.MethodDescriptor;

/**
 * Utilites for generating gRPC stats.
 *
 * @author Srujan Narkedamalli (snarkedamall@wavefront.com).
 */
public final class Utils {

  private Utils() {
  }

  /**
   * Extracts the gRPC service name from the full method name.
   *
   * @param fullMethodName of the gRPC method.
   * @return gRPC service name.
   */
  public static String getServiceName(String fullMethodName) {
    return fullMethodName.substring(0, fullMethodName.lastIndexOf('/'));
  }

  /**
   * Whether gRPC method is of streaming type.
   *
   * @param methodType type of the gRPC method for which to determine whether streaming or not.
   * @return true if its streaming gRPC.
   */
  public static boolean isStreamingMethod(MethodDescriptor.MethodType methodType) {
    if (methodType == MethodDescriptor.MethodType.SERVER_STREAMING ||
        methodType == MethodDescriptor.MethodType.CLIENT_STREAMING ||
        methodType == MethodDescriptor.MethodType.BIDI_STREAMING) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Give a friendly name of gRPC full methodName that can be used as a part of a metric name.
   *
   * @param fullMethodName fully qualified gRPC method name.
   * @return a grpc full method name which is metric name friendly
   */
  public static String getFriendlyMethodName(String fullMethodName) {
    return fullMethodName.replace("/", ".");
  }
}