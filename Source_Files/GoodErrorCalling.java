public static class ErrorHandlingCallAdapterFactory extends CallAdapter.Factory {
    @Override public CallAdapter<MyCall<?>> get(Type returnType, Annotation[] annotations,
        Retrofit retrofit) {
      if (getRawType(returnType) != MyCall.class) {
        return null;
      }
      if (!(returnType instanceof ParameterizedType)) {
        throw new IllegalStateException(
            "MyCall must have generic type (e.g., MyCall<ResponseBody>)");
      }
      final Type responseType = getParameterUpperBound(0, (ParameterizedType) returnType);
      final Executor callbackExecutor = retrofit.callbackExecutor();
      return new CallAdapter<MyCall<?>>() {
        @Override public Type responseType() {
          return responseType;
        }

        @Override public <R> MyCall<R> adapt(Call<R> call) {
          return new MyCallAdapter<>(call, callbackExecutor);
        }
      };
    }
  }
