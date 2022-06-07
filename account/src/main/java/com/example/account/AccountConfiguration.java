package com.example.account;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.example.account.grpc.GrpcChannelFactory;
import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountConfiguration extends Configuration {
  @Valid
  @NotNull
  private GrpcChannelFactory externalService;
}
