package in.jsb.jsb.util;

import android.app.Activity;
import android.content.Intent;

/**
 * /* @author on 1/11/17.
 ____                        _   _   ____  _             _
 |  _ \ _ __ __ _  __ _  __ _| |_(_) / ___|(_)_ __   __ _| |__
 | |_) | '__/ _` |/ _` |/ _` | __| | \___ \| | '_ \ / _` | '_ \
 |  __/| | | (_| | (_| | (_| | |_| |  ___) | | | | | (_| | | | |
 |_|   |_|  \__,_|\__, |\__,_|\__|_| |____/|_|_| |_|\__, |_| |_|
 |___/                             |___/
 *
 *  Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public final class UtilShare {




 public static  void  shareMe(final Activity ctx, final String title, final String message){
  Intent intent = new Intent(Intent.ACTION_SEND);
  intent.putExtra(Intent.EXTRA_TEXT,message);
  intent.setType("text/plain");
// Always use string resources for UI text.
// This says something like "Share this photo with"
 // Create intent to show chooser
  Intent chooser = Intent.createChooser(intent, title);
// Verify the intent will resolve to at least one activity
  if (intent.resolveActivity(ctx.getPackageManager()) != null) {
   ctx.startActivity(chooser);
  }
 }

/* public static void onShareClick(Activity ctx,String message,String email,String EmailSubject) {
  Resources resources = ctx.getResources();

  Intent emailIntent = new Intent();
  emailIntent.setAction(Intent.ACTION_SEND);
  emailIntent.putExtra(Intent.EXTRA_TEXT, message);        // Native email client doesn't currently support HTML, but it doesn't hurt to try in case they fix it
  emailIntent.putExtra(Intent.EXTRA_SUBJECT, EmailSubject);
  emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});

  emailIntent.setType("message/rfc822");

  PackageManager pm = ctx.getPackageManager();
  Intent sendIntent = new Intent(Intent.ACTION_SEND);
  sendIntent.putExtra(Intent.EXTRA_TEXT, message);
  sendIntent.setType("text/plain");


  Intent openInChooser = Intent.createChooser(emailIntent, resources.getString(R.string.share_chooser_text));

  List<ResolveInfo> resInfo = pm.queryIntentActivities(sendIntent, 0);
  List<LabeledIntent> intentList = new ArrayList<LabeledIntent>();
  for (int i = 0; i < resInfo.size(); i++) {
   // Extract the label, append it, and repackage it in a LabeledIntent
   ResolveInfo ri = resInfo.get(i);
   String packageName = ri.activityInfo.packageName;
   if(packageName.contains("android.email")) {
    emailIntent.setPackage(packageName);

   } else if(packageName.contains("twitter") || packageName.contains("facebook") || packageName.contains("mms") || packageName.contains("android.gm")) {
    Intent intent = new Intent();
    intent.setComponent(new ComponentName(packageName, ri.activityInfo.name));
    intent.setAction(Intent.ACTION_SEND);
    intent.setType("text/plain");
    if(packageName.contains("twitter")) {
     intent.putExtra(Intent.EXTRA_TEXT, resources.getString(R.string.share_twitter));
    } else if(packageName.contains("facebook")) {
     // Warning: Facebook IGNORES our text. They say "These fields are intended for users to express themselves. Pre-filling these fields erodes the authenticity of the user voice."
     // One workaround is to use the Facebook SDK to post, but that doesn't allow the user to choose how they want to share. We can also make a custom landing page, and the link
     // will show the <meta content ="..."> text from that page with our link in Facebook.
     intent.putExtra(Intent.EXTRA_TEXT, resources.getString(R.string.share_facebook));
    } else if(packageName.contains("mms")) {
     intent.putExtra(Intent.EXTRA_TEXT, resources.getString(R.string.share_sms));
    } else if(packageName.contains("android.gm")) { // If Gmail shows up twice, try removing this else-if clause and the reference to "android.gm" above
     intent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(resources.getString(R.string.share_gmail)));
     intent.putExtra(Intent.EXTRA_SUBJECT, resources.getString(R.string.share_gmailsubject));
     intent.setType("message/rfc822");
    }

    intentList.add(new LabeledIntent(intent, packageName, ri.loadLabel(pm), ri.icon));
   }
  }

  // convert intentList to array
  LabeledIntent[] extraIntents = intentList.toArray(new LabeledIntent[intentList.size()]);

  openInChooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, extraIntents);
  ctx.startActivity(openInChooser);
 }*/


     public static   void sendFeedBackEmail(final Activity ctx, final String message, final String EmailSubject){

         Intent emailIntent = new Intent();
         emailIntent.setAction(Intent.ACTION_SEND);
         emailIntent.putExtra(Intent.EXTRA_TEXT, message);        // Native email client doesn't currently support HTML, but
         emailIntent.putExtra(Intent.EXTRA_SUBJECT, EmailSubject);
         emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"feedback@caaring.in"});

         emailIntent.setType("message/rfc822");

         //Intent chooser = Intent.createChooser(emailIntent, "Feedback");

// Verify the intent will resolve to at least one activity
         if (emailIntent.resolveActivity(ctx.getPackageManager()) != null) {
             ctx.startActivity(emailIntent);

         }

     }

}
