

### 02 Async (Completion/Future)

- Throughput: amount of HTTP or Messages processed by time unit
- Syncronous/Blocking: Code that waits for task A to complete to process task B
- Async/Non-blocking: Code that will be executed at some time in the future. The CompletionAPI uses concurrency of threads to achieve non-blocking effect.


#### Async, Sync and ES

#### Triggering a Task on completion of another

CompletionStage: is the name of an interface
 
CompletableFuture: Class the the JDK gives you to implement CompletionStage. It turns out that CompletableFuture also implements the Future interface, so the obj you work with is
a CompletionStage and a Future.

You already wrote some task with the completable future API
Let us see that again you can submit a task with the `supplyAsync` factory method but to get the return is a Future Object you can call get, join (both are blocking!)

Instead you can call the `thenApply` method. This method takes a fn as a parameter and can do something without.
Your function will act at some point in the future so is non-blocking.

```
thenApply(
    emailInfos -> writeToDB(emailInfos));

doneCF.thenApply(done -> updateUI(done))
```

Do not block your main thread

- divide your processing in small ops
- chain ghem with the CompletionStage API