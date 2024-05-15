// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: skuListRes.proto

package com.google.protocol;

public interface UserOrBuilder extends
    // @@protoc_insertion_point(interface_extends:protocol.User)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 userId = 1;</code>
   */
  int getUserId();

  /**
   * <code>string username = 2;</code>
   */
  java.lang.String getUsername();
  /**
   * <code>string username = 2;</code>
   */
  com.google.protobuf.ByteString
      getUsernameBytes();

  /**
   * <code>string error = 3;</code>
   */
  java.lang.String getError();
  /**
   * <code>string error = 3;</code>
   */
  com.google.protobuf.ByteString
      getErrorBytes();

  /**
   * <code>int32 code = 4;</code>
   */
  int getCode();

  /**
   * <code>string name = 8;</code>
   */
  java.lang.String getName();
  /**
   * <code>string name = 8;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>.protocol.UserType userType = 9;</code>
   */
  int getUserTypeValue();
  /**
   * <code>.protocol.UserType userType = 9;</code>
   */
  com.google.protocol.UserType getUserType();

  /**
   * <code>repeated int32 roles = 10;</code>
   */
  java.util.List<java.lang.Integer> getRolesList();
  /**
   * <code>repeated int32 roles = 10;</code>
   */
  int getRolesCount();
  /**
   * <code>repeated int32 roles = 10;</code>
   */
  int getRoles(int index);

  public com.google.protocol.User.MsgCase getMsgCase();
}
