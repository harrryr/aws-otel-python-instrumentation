/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.config;

import io.opentelemetry.distros.DistroConfig;
import java.util.Arrays;
import java.util.stream.Stream;

/** Defines all test configurations */
public enum Configs {
  RELEASE(
      TestConfig.builder()
          .name("release")
          .description("compares no distro, latest stable, and latest snapshot distro")
          .withDistroConfigs(
              DistroConfig.NONE, DistroConfig.LATEST_RELEASE, DistroConfig.LATEST_SNAPSHOT)
          .warmupSeconds(60)
          .build());

  public final TestConfig config;

  public static Stream<TestConfig> all() {
    return Arrays.stream(Configs.values()).map(x -> x.config);
  }

  Configs(TestConfig config) {
    this.config = config;
  }
}
