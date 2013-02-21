// $ANTLR 3.5 com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g 2013-02-20 21:35:31
package com.khubla.pragmatach.framework.uri.antlr;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

@SuppressWarnings("all")
public class RouteSpecificationParser extends Parser {
   public static class id_return extends ParserRuleReturnScope {
      CommonTree tree;

      @Override
      public CommonTree getTree() {
         return tree;
      }
   }

   public static class idsegment_return extends ParserRuleReturnScope {
      CommonTree tree;

      @Override
      public CommonTree getTree() {
         return tree;
      }
   }

   public static class pathsegment_return extends ParserRuleReturnScope {
      CommonTree tree;

      @Override
      public CommonTree getTree() {
         return tree;
      }
   }

   public static class routespecification_return extends ParserRuleReturnScope {
      CommonTree tree;

      @Override
      public CommonTree getTree() {
         return tree;
      }
   }

   public static class segment_return extends ParserRuleReturnScope {
      CommonTree tree;

      @Override
      public CommonTree getTree() {
         return tree;
      }
   }

   public static final String[] tokenNames = new String[] { "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALPHANUM", "'/'", "'@'" };
   // delegators
   public static final int EOF = -1;
   public static final int T__5 = 5;
   public static final int T__6 = 6;
   public static final int ALPHANUM = 4;
   protected TreeAdaptor adaptor = new CommonTreeAdaptor();
   public static final BitSet FOLLOW_5_in_routespecification74 = new BitSet(new long[] { 0x0000000000000050L });
   public static final BitSet FOLLOW_segment_in_routespecification77 = new BitSet(new long[] { 0x0000000000000022L });
   public static final BitSet FOLLOW_pathsegment_in_segment88 = new BitSet(new long[] { 0x0000000000000002L });;
   public static final BitSet FOLLOW_idsegment_in_segment92 = new BitSet(new long[] { 0x0000000000000002L });
   public static final BitSet FOLLOW_6_in_idsegment101 = new BitSet(new long[] { 0x0000000000000010L });;
   public static final BitSet FOLLOW_id_in_idsegment104 = new BitSet(new long[] { 0x0000000000000002L });
   public static final BitSet FOLLOW_ALPHANUM_in_pathsegment113 = new BitSet(new long[] { 0x0000000000000002L });;
   public static final BitSet FOLLOW_ALPHANUM_in_id123 = new BitSet(new long[] { 0x0000000000000002L });

   public RouteSpecificationParser(TokenStream input) {
      this(input, new RecognizerSharedState());
   };

   public RouteSpecificationParser(TokenStream input, RecognizerSharedState state) {
      super(input, state);
   }

   // delegates
   public Parser[] getDelegates() {
      return new Parser[] {};
   };

   @Override
   public String getGrammarFileName() {
      return "com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g";
   }

   // Delegated rules
   @Override
   public String[] getTokenNames() {
      return RouteSpecificationParser.tokenNames;
   }

   public TreeAdaptor getTreeAdaptor() {
      return adaptor;
   }

   // $ANTLR start "id"
   // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:26:1: id : ALPHANUM ;
   public final RouteSpecificationParser.id_return id() throws RecognitionException {
      final RouteSpecificationParser.id_return retval = new RouteSpecificationParser.id_return();
      retval.start = input.LT(1);
      CommonTree root_0 = null;
      Token ALPHANUM8 = null;
      CommonTree ALPHANUM8_tree = null;
      try {
         // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:27:2: ( ALPHANUM )
         // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:27:4: ALPHANUM
         {
            root_0 = (CommonTree) adaptor.nil();
            ALPHANUM8 = (Token) match(input, ALPHANUM, FOLLOW_ALPHANUM_in_id123);
            if (state.failed) {
               return retval;
            }
            if (state.backtracking == 0) {
               ALPHANUM8_tree = (CommonTree) adaptor.create(ALPHANUM8);
               adaptor.addChild(root_0, ALPHANUM8_tree);
            }
         }
         retval.stop = input.LT(-1);
         if (state.backtracking == 0) {
            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
         }
      } catch (final RecognitionException re) {
         reportError(re);
         recover(input, re);
         retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
      } finally {
         // do for sure before leaving
      }
      return retval;
   }

   // $ANTLR end "id"
   // $ANTLR start "idsegment"
   // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:22:1: idsegment : '@' ^ id ;
   public final RouteSpecificationParser.idsegment_return idsegment() throws RecognitionException {
      final RouteSpecificationParser.idsegment_return retval = new RouteSpecificationParser.idsegment_return();
      retval.start = input.LT(1);
      CommonTree root_0 = null;
      Token char_literal5 = null;
      ParserRuleReturnScope id6 = null;
      CommonTree char_literal5_tree = null;
      try {
         // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:23:2: ( '@' ^ id )
         // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:23:4: '@' ^ id
         {
            root_0 = (CommonTree) adaptor.nil();
            char_literal5 = (Token) match(input, 6, FOLLOW_6_in_idsegment101);
            if (state.failed) {
               return retval;
            }
            if (state.backtracking == 0) {
               char_literal5_tree = (CommonTree) adaptor.create(char_literal5);
               root_0 = (CommonTree) adaptor.becomeRoot(char_literal5_tree, root_0);
            }
            pushFollow(FOLLOW_id_in_idsegment104);
            id6 = id();
            state._fsp--;
            if (state.failed) {
               return retval;
            }
            if (state.backtracking == 0) {
               adaptor.addChild(root_0, id6.getTree());
            }
         }
         retval.stop = input.LT(-1);
         if (state.backtracking == 0) {
            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
         }
      } catch (final RecognitionException re) {
         reportError(re);
         recover(input, re);
         retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
      } finally {
         // do for sure before leaving
      }
      return retval;
   }

   // $ANTLR end "idsegment"
   // $ANTLR start "pathsegment"
   // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:24:1: pathsegment : ALPHANUM ^;
   public final RouteSpecificationParser.pathsegment_return pathsegment() throws RecognitionException {
      final RouteSpecificationParser.pathsegment_return retval = new RouteSpecificationParser.pathsegment_return();
      retval.start = input.LT(1);
      CommonTree root_0 = null;
      Token ALPHANUM7 = null;
      CommonTree ALPHANUM7_tree = null;
      try {
         // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:25:2: ( ALPHANUM ^)
         // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:25:4: ALPHANUM ^
         {
            root_0 = (CommonTree) adaptor.nil();
            ALPHANUM7 = (Token) match(input, ALPHANUM, FOLLOW_ALPHANUM_in_pathsegment113);
            if (state.failed) {
               return retval;
            }
            if (state.backtracking == 0) {
               ALPHANUM7_tree = (CommonTree) adaptor.create(ALPHANUM7);
               root_0 = (CommonTree) adaptor.becomeRoot(ALPHANUM7_tree, root_0);
            }
         }
         retval.stop = input.LT(-1);
         if (state.backtracking == 0) {
            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
         }
      } catch (final RecognitionException re) {
         reportError(re);
         recover(input, re);
         retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
      } finally {
         // do for sure before leaving
      }
      return retval;
   }

   // $ANTLR end "pathsegment"
   // $ANTLR start "routespecification"
   // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:18:1: routespecification : ( '/' ! segment )+ ;
   public final RouteSpecificationParser.routespecification_return routespecification() throws RecognitionException {
      final RouteSpecificationParser.routespecification_return retval = new RouteSpecificationParser.routespecification_return();
      retval.start = input.LT(1);
      CommonTree root_0 = null;
      Token char_literal1 = null;
      ParserRuleReturnScope segment2 = null;
      final CommonTree char_literal1_tree = null;
      try {
         // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:19:2: ( ( '/' ! segment )+ )
         // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:19:4: ( '/' ! segment )+
         {
            root_0 = (CommonTree) adaptor.nil();
            // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:19:4: ( '/' ! segment )+
            int cnt1 = 0;
            loop1: while (true) {
               int alt1 = 2;
               final int LA1_0 = input.LA(1);
               if ((LA1_0 == 5)) {
                  alt1 = 1;
               }
               switch (alt1) {
                  case 1:
                  // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:19:5: '/' ! segment
                  {
                     char_literal1 = (Token) match(input, 5, FOLLOW_5_in_routespecification74);
                     if (state.failed) {
                        return retval;
                     }
                     pushFollow(FOLLOW_segment_in_routespecification77);
                     segment2 = segment();
                     state._fsp--;
                     if (state.failed) {
                        return retval;
                     }
                     if (state.backtracking == 0) {
                        adaptor.addChild(root_0, segment2.getTree());
                     }
                  }
                     break;
                  default:
                     if (cnt1 >= 1) {
                        break loop1;
                     }
                     if (state.backtracking > 0) {
                        state.failed = true;
                        return retval;
                     }
                     final EarlyExitException eee = new EarlyExitException(1, input);
                     throw eee;
               }
               cnt1++;
            }
         }
         retval.stop = input.LT(-1);
         if (state.backtracking == 0) {
            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
         }
      } catch (final RecognitionException re) {
         reportError(re);
         recover(input, re);
         retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
      } finally {
         // do for sure before leaving
      }
      return retval;
   }

   // $ANTLR end "routespecification"
   // $ANTLR start "segment"
   // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:20:1: segment : ( pathsegment | idsegment );
   public final RouteSpecificationParser.segment_return segment() throws RecognitionException {
      final RouteSpecificationParser.segment_return retval = new RouteSpecificationParser.segment_return();
      retval.start = input.LT(1);
      CommonTree root_0 = null;
      ParserRuleReturnScope pathsegment3 = null;
      ParserRuleReturnScope idsegment4 = null;
      try {
         // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:21:2: ( pathsegment | idsegment )
         int alt2 = 2;
         final int LA2_0 = input.LA(1);
         if ((LA2_0 == ALPHANUM)) {
            alt2 = 1;
         } else if ((LA2_0 == 6)) {
            alt2 = 2;
         } else {
            if (state.backtracking > 0) {
               state.failed = true;
               return retval;
            }
            final NoViableAltException nvae = new NoViableAltException("", 2, 0, input);
            throw nvae;
         }
         switch (alt2) {
            case 1:
            // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:21:4: pathsegment
            {
               root_0 = (CommonTree) adaptor.nil();
               pushFollow(FOLLOW_pathsegment_in_segment88);
               pathsegment3 = pathsegment();
               state._fsp--;
               if (state.failed) {
                  return retval;
               }
               if (state.backtracking == 0) {
                  adaptor.addChild(root_0, pathsegment3.getTree());
               }
            }
               break;
            case 2:
            // com/khubla/pragmatach/framework/uri/antlr/RouteSpecification.g:21:18: idsegment
            {
               root_0 = (CommonTree) adaptor.nil();
               pushFollow(FOLLOW_idsegment_in_segment92);
               idsegment4 = idsegment();
               state._fsp--;
               if (state.failed) {
                  return retval;
               }
               if (state.backtracking == 0) {
                  adaptor.addChild(root_0, idsegment4.getTree());
               }
            }
               break;
         }
         retval.stop = input.LT(-1);
         if (state.backtracking == 0) {
            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
         }
      } catch (final RecognitionException re) {
         reportError(re);
         recover(input, re);
         retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);
      } finally {
         // do for sure before leaving
      }
      return retval;
   }

   // $ANTLR end "segment"
   public void setTreeAdaptor(TreeAdaptor adaptor) {
      this.adaptor = adaptor;
   }
}
