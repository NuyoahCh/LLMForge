本篇介绍了AI的一些核心概念，有利于你理解大模型开发的一些原理。





<h1 id="cQ7s9">人工智能发展</h1>
AI，人工智能（Artificial Intelligence），使机器能够像人类一样思考、学习和解决问题的技术。



AI发展至今大概可以分为三个阶段：



![](https://cdn.nlark.com/yuque/0/2025/png/45054063/1761032652679-54aa63c3-6f0c-4015-acbb-6ad0191d874f.png)



其中，深度学习领域的自然语言处理(Natural Language Processing, NLP)有一个关键技术叫做Transformer，这是一种由多层感知机组成的神经网络模型，是现如今AI高速发展的最主要原因。



我们所熟知的大模型（Large Language Models, LLM），例如GPT、DeepSeek底层都是采用Transformer神经网络模型。



以GPT模型为例，其三个字母的缩写分别是Generative、Pre-trained、Transformer：



![](https://cdn.nlark.com/yuque/0/2025/png/45054063/1761032652737-0171c582-b5e6-4b2d-87b0-111a8c131257.png)



那么问题来， Transformer神经网络有什么神奇的地方，可以实现如此强大的能力呢？





<h1 id="6d445af5">大模型原理</h1>
其实，最早Transformer是由Google在2017年提出的一种神经网络模型，一开始的作用是把它作为机器翻译的核心：



![](https://cdn.nlark.com/yuque/0/2025/gif/45054063/1761032652773-d1d308ba-3d1c-4a27-957c-bd964274f37f.gif)



Transformer中提出的注意力机制使得神经网络在处理信息时可以根据上下内容调整对数据的理解，变得更加智能化。这不仅仅是说人类的文字，包括图片、音频数据都可以交给Transformer来处理。于是，越来越多的模型开始基于Transformer实现了各种神奇的功能。



例如，有的模型可以根据音频生成文本，或者根据文本生成音频：



![](https://cdn.nlark.com/yuque/0/2025/gif/45054063/1761032652758-da299703-d26a-415e-8ae1-9e33584fa301.gif)



还有的模型则可以根据文字生成图片，比如Dall-E、MidJourney：



![](https://cdn.nlark.com/yuque/0/2025/gif/45054063/1761032652735-32844c32-0912-49df-b76a-91d0fce517eb.gif)



不过，我们今天要聊的大语言模型（Large Language Models, 以下简称LLM）是对Transformer的另一种用法：推理预测。



LLM在训练Transformer时会尝试输入一些文本、音频、图片等信息，然后让Transformer推理接下来跟着的应该是什么内容。推理的结果会以概率分布的形式出现：



![](https://cdn.nlark.com/yuque/0/2025/gif/45054063/1761032653349-eeac3b34-3571-4b74-9840-425de4f7a7f4.gif)



可能大家会有疑问：

仅仅是推测接下来的内容，怎么能让ChatGPT在对话中生成大段的有关联的文字内容呢？

其实LLM采用的就是笨办法，答案就是：持续生成。



根据前文推测出接下来的一个词语后，把这个词语加入前文，再次交给大模型处理，推测下一个字，然后不断重复前面的过程，就可以生成大段的内容了：



![](https://cdn.nlark.com/yuque/0/2025/gif/45054063/1761032653561-ae5aaf58-a29e-41d9-a625-1c1ff998a375.gif)



这就是为什么我们跟AI聊天的时候，它生成的内容总是一个字一个字的输出的原因了。

以上就是LLM的核心技术，Transformer的原理了~



如果大家想要进一步搞清楚Transformer机制，可以参考以下视频：

[https://www.bilibili.com/video/BV1atCRYsE7x/](https://www.bilibili.com/video/BV1atCRYsE7x/)





<h1 id="MorFq">总结</h1>
对于我们当下作为应用层面的使用者，或者是服务端/客户端开发的工程师，我们在大多数时候，不需要深入的理解大模型底层的架构和原理，更多的是要求我们将大模型领域应用到我们日常的生活和工作过程中。



最近也有很多大模型应用开发相关的领域，所以对于这些方式，我们更重要的是学会怎么去使用，而不是深究其本质和原理，有些时候使用比原理更加重要（当然，原理会让我们理解的更为透彻，思考的更加深入），所以如何让先进的大模型应用技术进行落地，也是我们十分需要关注的问题。

