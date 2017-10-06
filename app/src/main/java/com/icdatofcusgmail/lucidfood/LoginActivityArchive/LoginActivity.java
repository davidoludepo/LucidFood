package com.icdatofcusgmail.lucidfood.LoginActivityArchive;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PowerManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.easyandroidanimations.library.BounceAnimation;
import com.easyandroidanimations.library.ShakeAnimation;
import com.icdatofcusgmail.lucidfood.FoodmenuActivityArchive.FoodmenuActivity;
import com.icdatofcusgmail.lucidfood.LucidApplication;
import com.icdatofcusgmail.lucidfood.MyCountlesston;
import com.icdatofcusgmail.lucidfood.R;
import com.icdatofcusgmail.lucidfood.VendorActivityArchive.VendorActivity;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class LoginActivity extends AppCompatActivity {

    PowerManager.WakeLock wakeLock;
    int intRandom;
    TextView reporterPassword, reporterUsername, textRandom;
    ArrayList<String> arrayRandom;
    public EditText UsernameField;
    public EditText PasswordField;
    Button login;
    public ImageButton clearAllUsername, clearAllPin;
    AlertDialog.Builder quantumElevation;
    Date whoShouldIDate;
    TextView actuallyTime;

    String turnUp_url = "http://192.168.43.79/my_login_okay.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("LoginActivity","onCreate invoked");

        quantumElevation = new AlertDialog.Builder(LoginActivity.this);

        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "deprecatedmyfoot");
        wakeLock.acquire();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        }

        UsernameField = (EditText) findViewById(R.id.Usernamefield);
        PasswordField = (EditText) findViewById(R.id.Passwordfield);

        login = (Button) findViewById(R.id.loginbutton);

        clearAllUsername = (ImageButton) findViewById(R.id.clearAllUsername);
        clearAllPin = (ImageButton) findViewById(R.id.clearAllPin);
        clearAllUsername.setVisibility(View.GONE);
        clearAllPin.setVisibility(View.GONE);

        reporterPassword = (TextView) findViewById(R.id.reportPassWord);
        reporterUsername = (TextView) findViewById(R.id.reportUserName);

        actuallyTime = (TextView) findViewById(R.id.HiddenCurrentTyme);
        actuallyTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShakeAnimation(actuallyTime).animate();
            }
        });

        whoShouldIDate = new Date(System.currentTimeMillis());
        SimpleDateFormat notComplexFormat = new SimpleDateFormat("yyyy - MM - dd", Locale.ENGLISH);
        String strrrinng = notComplexFormat.format(whoShouldIDate);
        actuallyTime.setText(strrrinng);

        textRandom = (TextView) findViewById(R.id.RandomMotivation);
        textRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BounceAnimation(textRandom).setBounceDistance(50)
                        .setBounceDistance(50)
                        .setDuration(1500)
                        .animate();
            }
        });

        arrayRandom = new ArrayList<>();

            this.arrayRandom.add("Don't follow trends, start trends.");
            this.arrayRandom.add("Success is often achieved by those who don't know that failure is inevitable.");
            this.arrayRandom.add("Happy Day");
            this.arrayRandom.add("Problems are not stop signs, they are guidelines.");
            this.arrayRandom.add("We have to have the mentality that we have to work for everything we're going to get.");
            this.arrayRandom.add("If you don't fall how are you going to know what getting up is like.");
            this.arrayRandom.add("Just because you don't see a way doesn't mean God doesn't have a way.");
            this.arrayRandom.add("Find your dream, then risk everything to make it into reality.");
            this.arrayRandom.add("The distance between your dreams and reality is called Action.");
            this.arrayRandom.add("'Why Not' is a slogan for an interesting life.");
            this.arrayRandom.add("Life is 10% what happens to us and 90% how we react to it.");
            this.arrayRandom.add("Every morning you have two choices:\n Continue to sleep with your dreams \n or Wake up and chase them.");
            this.arrayRandom.add("Working hard for something we don't care about is called stress; \n working hard for something we love is called passion.");
            this.arrayRandom.add("Don't think about doing it. Just do it.");
            this.arrayRandom.add("If you are born Poor, It's not your mistake. \n But if you die poor, It's yours.");
            this.arrayRandom.add("Think about the result you can get, and your goals you can reach, by simply moving your feet.");
            this.arrayRandom.add("No person is born great. \n People become great when others are sleeping.");
            this.arrayRandom.add("Great spirits have often encountered violent opposition from weak minds. It's Okay.");
            this.arrayRandom.add("If you can't explain it to aix year old, you don't understand it yourself.");
            this.arrayRandom.add("Logic will get you from A to Z; \n Imagination will get you everywhere.");
            this.arrayRandom.add("It's not that I'm so smart; \n It's just that I stay with problems longer.");
            this.arrayRandom.add("The person who never made a mistake never tried anything new.");
            this.arrayRandom.add("I have no Special talents. I am only passionately curious.");
            this.arrayRandom.add("In order to succeed, we must first believe that we can.");
            this.arrayRandom.add("Example isn't another way to teach, it is the only way to teach.");
            this.arrayRandom.add("If a cluttered desk is a sign of an empty mind, of what then, is an empty desk?");
            this.arrayRandom.add("The world is a dangerous place, not because of those who do evil, but because of those who look on and do nothing.");
            this.arrayRandom.add("Everybody is a genius. But if you judge the a fish by its ability to climb a tree, it will live its whole life believing that it is stupid.");
            this.arrayRandom.add("When you are courting a nice girl an hour seems like a second. When you sit on a red-hot cinder a second seems like an hour. That's relativity.");
            this.arrayRandom.add("A clever person solves a problem. A wise person avoids it.");
            this.arrayRandom.add("A ship is always safe at a the shore - but that is not what it is built for.");
            this.arrayRandom.add("If people are good only because they fear punishment, and hope for reward, then we are a sorry lot indeed.");
            this.arrayRandom.add("Never lose an holy curiosity.");
            this.arrayRandom.add("Paper is to write things down that we need to remember. Our brains are used to think.");
            this.arrayRandom.add("My Best Friend is a person who will give me a book I have not read.");
            this.arrayRandom.add("You have to do your own growing no matter how tall your grandfather was.");
            this.arrayRandom.add("Always bear in mind that your own resolution to succeed is more important than any other thing.");
            this.arrayRandom.add("That some achieve great success is proof to all that others can achieve it as well.");
            this.arrayRandom.add("It is better to remain silent and be thought a fool, than to open your mouth and remove all doubt.");
            this.arrayRandom.add("Those who look for the bad in people will surely find it.");
            this.arrayRandom.add("You can't cross the sea merely by standing and staring at the water.");
            this.arrayRandom.add("Dream, Dream, Dream, Dreams transform into thoughts and thoughts result into action.");
            this.arrayRandom.add("Dreams are not those which comes while we are sleeping, but dreams are those when you don't sleep before fulfilling them.");
            this.arrayRandom.add("Don't take rest after your first victory because if you fail in second, more lips are waiting to say that your first victory was just luck.");
            this.arrayRandom.add("As a child of God, I am greater than anything that can happen to me.");
            this.arrayRandom.add("Look at the sky. We are not alone. The whole universe is friendly to us and conspires only to give the best to those who dream and work.");
            this.arrayRandom.add("Let us sacrifice our today so that our children can have a better tomorrow.");
            this.arrayRandom.add("Three things cannot be long hidden: the sun, the moon, and the truth.");
            this.arrayRandom.add("Holding on to an anger is like grasping a hot coal with the intent of throwing it at someone else; you are the one who gets burned.");
            this.arrayRandom.add("He who loves 50 people has 50 woes; he who loves no one has no woes.");
            this.arrayRandom.add("Peace comes from within. Do not seek it without.");
            this.arrayRandom.add("Whatever words we utter should be chosen with care for people will hear them and be influenced by them for good or ill.");
            this.arrayRandom.add("Life's tragedy is that we get old too soon and wise too late.");
            this.arrayRandom.add("There are three things extremely hard: steel, a diamond, and to know one's self.");
            this.arrayRandom.add("I failed in some subjects in exam, but my friend passed in all. Now he is an engineer in Microsoft and I am the owner of Microsoft.");
            this.arrayRandom.add("I studied everything but never topped.... But today the toppers of the best universities are my employees.");
            this.arrayRandom.add("You must not complete your sleep in life. There will be sleeping enough in the grave.");
            this.arrayRandom.add("Be nice to nerds. Chances are you'll end up working for one.");
            this.arrayRandom.add("Life is not fair, get over it!");
            this.arrayRandom.add("It's fine to celebrate success, but it is more important to heed the lessons of failure.");
            this.arrayRandom.add("Always do your best. What you plant now, you will harvest later.");
            this.arrayRandom.add("Patience is a key element to success.");

            this.arrayRandom.add("In order to succeed, your desire for success should be greater than your fear of failure.");
            this.arrayRandom.add("Parents are not interested in justice, they're interested in peace and quiet.");
            this.arrayRandom.add("If you want to be seen, stand up. \n If you want to be heard, speak up. \n If you want to be appreciated, shut up.");
            this.arrayRandom.add("Human beings are the only creatures on earth that allow their children to come back home.");
            this.arrayRandom.add("So many books. So little time.");
            this.arrayRandom.add("There is no friend as loyal as a book.");
            this.arrayRandom.add("Never trust anyone who has not brought a book with them.");
            this.arrayRandom.add("Think before you speak. Read before you think.");
            this.arrayRandom.add("Only the very weak-minded refuse to be influenced by literature and poetry.");
            this.arrayRandom.add("Anyone who says they have only one life to live must know how to read a book.");
            this.arrayRandom.add("If you think your boss is stupid remember: \n You wouldn't have a job if he was any smarter.");
            this.arrayRandom.add("By failing to prepare, you are preparing to fail.");
            this.arrayRandom.add("The man who will use his skill and constructive imagination to see how much he can give for a dollar, instead of how little he can give for a dollar, is bound to succeed.");
            this.arrayRandom.add("The secret to success in business, and in life, is to serve others. Put others first in all you do.");
            this.arrayRandom.add("We are what we repeatedly do. Excellence then, is not a single act, but an habit.");
            this.arrayRandom.add("Confidence is contagious; so is lack of confidence.");
            this.arrayRandom.add("Choose a job you love. And you will never have to work a day in your life.");
            this.arrayRandom.add("Everything has beauty, but not everyone sees it.");
            this.arrayRandom.add("Our greatest glory is not in never falling, but in rising every time we fall.");
            this.arrayRandom.add("No matter how busy you may think you are, you must find time reading, or surrender yourself to self-chosen ignorance.");
            this.arrayRandom.add("It does not matter how slowly you go as long as you do not stop.");
            this.arrayRandom.add("The man who asks a question is a fool for a minute, the man who does not ask is a fool for life.");
            this.arrayRandom.add("The beginning of wisdom is to call things by their proper name.");
            this.arrayRandom.add("When anger rises, think of the consequences.");
            this.arrayRandom.add("You cannot open a book without learning something.");
            this.arrayRandom.add("Once you start working on something, don't be afraid of failure and don't abandon it. People who work sincerely are the happiest.");
            this.arrayRandom.add("It is not the strongest of the species that survives, nor the most intelligent, but the one most responsive to change.");
            this.arrayRandom.add("If you can dream it, you can do it.");
            this.arrayRandom.add("A man who dares to waste one hour of time has not discovered the value of life.");
            this.arrayRandom.add("Never close your lips to those whom you have already opened your heart.");
            this.arrayRandom.add("To a young heart everything is fun.");
            this.arrayRandom.add("My advice is to never do tomorrow what you can do today. Procrastination is the thief of time.");
            this.arrayRandom.add("A day without laughter is a day wasted.");
            this.arrayRandom.add("I don't dream at night, I dream all day; I dream for a living.");
            this.arrayRandom.add("The future belongs to those who believe in the beauty of their dreams.");
            this.arrayRandom.add("All our dreams can come true, if we have courage to pursue them.");
            this.arrayRandom.add("No dreamer is ever too small; no dream is ever too big.");
            this.arrayRandom.add("I believe in revenge. The best revenge is massive success. Decide to be massively successful");
            this.arrayRandom.add("Dare to live the life you have dreamed for yourself. Go forward and make your dreams come true.");
            this.arrayRandom.add("At first dreams seem impossible, then improbable, then inevitable.");
            this.arrayRandom.add("Don't be afraid of the space between your dreams and reality. If you can dream it, you can make it so.");
            this.arrayRandom.add("It's not important how long you live, what's important is how you live.");
            this.arrayRandom.add("Commitment leads to action. Action brings your dream closer.");
            this.arrayRandom.add("You see things and you say 'Why?' But I dream things that never were and I say 'Why not?'");
            this.arrayRandom.add("Champions aren't made in the gys. Champions are made from something they have deep inside them \n A desire \n A dream \n A vision.");
            this.arrayRandom.add("Stand often in the the company of dreamers. They believe you can achieve impossible things.");
            this.arrayRandom.add("A dream is not something that you wake up from, but something that wakes you up.");
            this.arrayRandom.add("What you do everyday matters more than what you do every once in a while.");
            this.arrayRandom.add("Today is only one day in all the days that will ever be. But what will happen in all the other days that ever come can depend on what you do today.");
            this.arrayRandom.add("Science never solves a problem without creating ten more.");
            this.arrayRandom.add("Life isn't about finding yourself. Life is about creating yourself.");
            this.arrayRandom.add("A life spent making mistakes is not only more honorable, but more useful than a life spent doing nothing.");
            this.arrayRandom.add("Those who cannot change their minds cannot change anything.");
            this.arrayRandom.add("As long as I have a want, I have a reason for living. Satisfaction is death.");
            this.arrayRandom.add("Whether you think you can, or you think you can't \n You're right.");
            this.arrayRandom.add("Always Dream big..One Day you'll Do It..");
            this.arrayRandom.add("Failure is simply an opportunity to begin again, this time more intelligently.");
            this.arrayRandom.add("My best friend is the one who brings out the best in me.");
            this.arrayRandom.add("The only real mistake is the one from which we learn nothing.");
            this.arrayRandom.add("Opportunity often comes disguised in the form of misfortune, or temporary defeat.");
            this.arrayRandom.add("Quality means doing it right when no one is looking.");
            this.arrayRandom.add("Those who walk with God, always reach their destination.");
            this.arrayRandom.add("Most people think that faith means believing something; \n Often it means trying something, giving it a chance to prove itself.");
            this.arrayRandom.add("I like work: it fascinates me. I can sit and look at it for hours.");
            this.arrayRandom.add("A problem is a chance for you to do your best");
            this.arrayRandom.add("The unhappiest and unsuccessful people in this world, are those who care the most about what other people think.");
            this.arrayRandom.add("The ultimate measure of a man is not where he stands in moments of comfort and convenience, but where he stands at times of challenge and controversy.");
            this.arrayRandom.add("Take time to deliberate, but when the time for action has arrived stop thinking and go in.");
            this.arrayRandom.add("You just can't beat the person who never gives up.");
            this.arrayRandom.add("The pessimist sees difficulty in every opportunity. The optimist sees opportunity in every difficulty.");
            this.arrayRandom.add("I have failed over and over again \n that is why I succeed.");
            this.arrayRandom.add("The only way of finding the limits of the possible is by going beyond them into the impossible.");
            this.arrayRandom.add("People become successful the minute they decide to.");
            this.arrayRandom.add("The size of your success depends on the depth of your desire");
            this.arrayRandom.add("You may be disappointed if you fail, but you are doomed if you do not try.");
            this.arrayRandom.add("Never give up! Failure and rejection are only the first step to succeeding.");
            this.arrayRandom.add("Don't wish for it.... Work for it!");
            this.arrayRandom.add("If your actions inspire others to dream more, learn more, do more and become more, you are a leader");

            this.arrayRandom.add("Think BIG! You are going to be thinking anyway, so think BIG!");
            this.arrayRandom.add("People become really quite remarkable when they start thinking that they can do things. When they believe in themselves, they have the first secret of success.");
            this.arrayRandom.add("Be courageous! Have faith! Go forward.");
            this.arrayRandom.add("Do not settle for less than an extraordinary life.");
            this.arrayRandom.add("You've got to get up every morning wih determination if you're going to go to bed with satisfaction.");
            this.arrayRandom.add("If you have goals and procrastination you have nothing. If you have goals and you take action, you will have anything you want.");
            this.arrayRandom.add("Remember, if you want a different result, do something different.");
            this.arrayRandom.add("Successful people in this world are those who get up and look for circumstances they want. If they can't find them, they create them. Create what you want.");
            this.arrayRandom.add("Imagination is more important than knowledge.");
            this.arrayRandom.add("The greater the obstacle, the more glory in achieving it.");
            this.arrayRandom.add("A man is but the product of his thoughts what he thinks, he becomes.");
            this.arrayRandom.add("You must be change you wish to see in the world.");
            this.arrayRandom.add("Nobody can hurt me without my permission");
            this.arrayRandom.add("It always seems impossible until it's done.");
            this.arrayRandom.add("The weak can never forgive. Forgiveness is the attribute of the strong.");
            this.arrayRandom.add("An ounce of practice is worth more than tons of preaching.");
            this.arrayRandom.add("The difference between School and Internet is discipline.");
            this.arrayRandom.add("First they ignore you, then they laugh at you, then they fight you, then you win.");
            this.arrayRandom.add("What is faith worth if it is not translated into action?");
            this.arrayRandom.add("The best way to find yourself is to lose yourself in the service of service of others.");
            this.arrayRandom.add("If I had no sense of humor, I would long ago have committed suicide.");
            this.arrayRandom.add("Power is of two kinds. One is obtained by the fear of punishment and the other by acts of love. Power based o love is a thousand times more effective and permanent then the one derived from fear of punishment.");
            this.arrayRandom.add("If you can't feed a hundred people, feed just one.");
            this.arrayRandom.add("People are often unreasonable and self-centered. Forgive them anyway.");
            this.arrayRandom.add("God doesn't require you to succeed, he only requires you try.");
            this.arrayRandom.add("The most terrible poverty is loneliness, and the feeling of being unloved.");
            this.arrayRandom.add("Jesus said love one another. He didn't say love the whole world.");
            this.arrayRandom.add("One of the greatest diseases is to be nobody to anybody.");
            this.arrayRandom.add("When you have nothing but God, you have more than enough to start over again.");
            this.arrayRandom.add("Spread love everywhere you go. Let no one ever come to you without leaving happier.");
            this.arrayRandom.add("If you tell the truth, you don't have to remember anything.");
            this.arrayRandom.add("Whenever you find yourself on the side of the majority, it is time to pause and reflect.");
            this.arrayRandom.add("Great people are those who make others feel that they, too can become great.");
            this.arrayRandom.add("Don't go around saying the world owes you a living. The world owes you nothing. It was here first.");
            this.arrayRandom.add("The dictionary is the only place where success comes before work.");
            this.arrayRandom.add("If you pick up a starving dog and make him prosperous he will not bite you. This is the principal difference between a dog and man.");
            this.arrayRandom.add("The two most important days in your life are, the day you are born and the day you find out why.");
            this.arrayRandom.add("Plan for the future because that's where you are going to spend the rest of your life.");
            this.arrayRandom.add("To succeed in life, you need two things: ignorance anf confidence.");
            this.arrayRandom.add("We should all start to live before we get too old. Fear is stupid. So are regrets.");
            this.arrayRandom.add("Always forgive your enemies; nothing annoys them so much.");
            this.arrayRandom.add("A good friend will always stab you in the front.");
            this.arrayRandom.add("Most people are other people. Their thoughts are someone else's opinions, their lives a mimicry, their passions a quotation.");
            this.arrayRandom.add("Don't limit a child to your own learning, for he was born in another time.");
            this.arrayRandom.add("When you came you cried and everybody smiled with joy; when you go smile and let the world cry for you.");
            this.arrayRandom.add("In three words I can sum up everything I've learned about life: it goes on.");
            this.arrayRandom.add("Never be bullied into silence. Never allow yourself to be made a victim. Accept no one's definition of your life; define yourself.");
            this.arrayRandom.add("Strong minds discuss ideas, average minds discuss events, weak minds discuss people.");
            this.arrayRandom.add("Tell the truth boldly, whether it hurts or not.");
            this.arrayRandom.add("In a conflict between the heart and the brain, follow your heart.");
            this.arrayRandom.add("Innovation distinguishes between a leader and a follower.");
            this.arrayRandom.add("Stay hungry and foolish.");
            this.arrayRandom.add("Sometimes life hits you in the head with the brick. Don't lose faith.");
            this.arrayRandom.add("To turn really interesting ideas and fledgling technologies into a company that can continue to innovate for years, it requires a lot of disciplines.");
            this.arrayRandom.add("Never, never, never, never give up.");
            this.arrayRandom.add("Your best success comes after your greatest disappointments.");
            this.arrayRandom.add("Success seems to be connected with action. Successful people keep moving. They make mistakes, but they don't quit.");
            this.arrayRandom.add("For true success ask your these four questions: Why? Why not? Why not me? Why not now?");
            this.arrayRandom.add("You just can't beat the person who never gives up.");
            this.arrayRandom.add("Successful people are always looking for opportunities to help others. \n Unsuccessful people are always asking. 'What's in it for me?'");
            this.arrayRandom.add("The only man who never makes mistakes is the man who never does anything.");
            this.arrayRandom.add("Do not go where the path may lead. go instead where there is no path and leave a trail.");
            this.arrayRandom.add("Success is doing ordinary things extraordinarily well.");
            this.arrayRandom.add("The greatest barrier to success is the fear of failure.");
            this.arrayRandom.add("Many of life's failures are people who did not realize how close they were to success when they gave up.");
            this.arrayRandom.add("Success often comes to those who dare to act. Its seldom goes to the timid who are ever afraid of the consequences.");
            this.arrayRandom.add("There is no substitute for hard work.");
            this.arrayRandom.add("We often miss opportunity because it's dressed in overalls and looks like work.");
            this.arrayRandom.add("To invent, you need a good imagination and a pile of junk.");
            this.arrayRandom.add("Our greatest weakness lies in giving up. The most certain way to succeed is to try just one more time.");
            this.arrayRandom.add("The hardest thing to do is thinking");
            this.arrayRandom.add("Five percent of the people think; \n Ten percent of the people think they think; \n and the other Eighty-Five percent would rather die than think.");
            this.arrayRandom.add("I never did a day's work in my life. It was all fun.");
            this.arrayRandom.add("We have but two ears and one mouth so that we may listen as twice as much as we speak.");
            this.arrayRandom.add("I find out what the world needs. Then I go ahead and try to invent it.");
            this.arrayRandom.add("If we did all the things we are capable of, we would literally astound ourselves.");
            this.arrayRandom.add("Be courageous! Have faith! Go forward.");
            this.arrayRandom.add("The harder you work, the luckier you get.");

            this.arrayRandom.add("I am not discouraged, because every wrong attempt discarded is another step forward.");
            this.arrayRandom.add("Relentless and discontent are the first necessities of progress.");
            this.arrayRandom.add("Show me a thoroughly satisfied man and I will show you a failure.");
            this.arrayRandom.add("There is no expedient to which a man will not go to avoid the labor of thinking.");
            this.arrayRandom.add("Burdens shared are easier to bear.");
            this.arrayRandom.add("None of us is as smart as all of us.");
            this.arrayRandom.add("The best teamwork comes from men who are working independently toward one goal in unison.");
            this.arrayRandom.add("Even the darkest night will end and the sun will rise.");
            this.arrayRandom.add("To love another person is t see the face of God.");
            this.arrayRandom.add("The future has several names. For the weak, it is impossible; for the fainthearted, it is unknown; but for the valiant, it is ideal.");
            this.arrayRandom.add("People do not lack strength, they lack will.");
            this.arrayRandom.add("If tomorrow hold a promise, what will you give for it today.");
            this.arrayRandom.add("Torrented movies aren't real life, get up and grind.");
            this.arrayRandom.add("People that are hungry no excuse is acceptable for not making their dream a reality. Be Hungry.");
            this.arrayRandom.add("Winners win and Losers loose.");
            this.arrayRandom.add("Be not afraid of greatness. Some are born great, some achieve greatness, and others have greatness thrust upon them.");
            this.arrayRandom.add("Nothing will come of nothing; we must dare mighty things.");
            this.arrayRandom.add("The price for greatness is responsibility.");
            this.arrayRandom.add("If you are going through hell, keep going.");
            this.arrayRandom.add("You will never reach your destination if you stop and throw stones at every dog that barks.");
            this.arrayRandom.add("You make a living by what you get. You make a life by what you give.");
            this.arrayRandom.add("Continuous effort! not strength or intelligence, is the key to unlocking your potential.");
            this.arrayRandom.add("Sometimes our best is simply not enough. We have to do what is required.");
            this.arrayRandom.add("There is no time for ease and comfort. It is the time to dare and endure.");
            this.arrayRandom.add("It's kind of fun to do the impossible.");
            this.arrayRandom.add("No matter how your heart is grieving, if you keep on believing, the dreams that you wish will come true.");
            this.arrayRandom.add("The way to get started is to quit talking and begin doing.");
            this.arrayRandom.add("Nothing is impossible. Nothing.");
            this.arrayRandom.add("Nothing in this world that's worth having comes easy");

            this.arrayRandom.add("The difference in winning and loosing is most often, not quitting.");
            this.arrayRandom.add("The era we are living in today is a dream of coming true.");
            this.arrayRandom.add("What the wise do in the beginning, the fools do in the end.");
            this.arrayRandom.add("Without passion, you don't have energy. Without energy, you are nothing.");
            this.arrayRandom.add("It takes 20 years to build a reputation and five minutes to ruin it. If you think about that you'll do things differently.");
            this.arrayRandom.add("Honesty is a very expensive gift, don't expect it from cheap people.");
            this.arrayRandom.add("You can't produce a baby in one month by getting nine women pregnant.");
            this.arrayRandom.add("A man only learns in two ways, one by reading, and the other by association with smarter people.");
            this.arrayRandom.add("Everybody is ignorant only on different subjects.");
            this.arrayRandom.add("If you wanna shine like a diamond you gonna get cut like a diamond.");
            this.arrayRandom.add("The version you are today is good,, but ain't great and definitely ain't phenomenal.");
            this.arrayRandom.add("When you wanna succeed as bad as you wanna breathe then you'll be successful.");
            this.arrayRandom.add("How many ghosts of dreams and ideas will be on your death bed. How many.");
            this.arrayRandom.add("You must be willing to do what others won't do inorder to have what others won't have.");
            this.arrayRandom.add("Many people don't work on their dreams. Why? Because of fear the fear of failure and the fear of success.");
            this.arrayRandom.add("It's wise for a man to bear his yoke in his youth. You wil bear it anyway.");
            this.arrayRandom.add("Don't cheat the system. If you don't pay now, you will pay double later.");
            this.arrayRandom.add("No matter bad it is or how bad it get's I'm going to make it.");
            this.arrayRandom.add("I work on my dreams. Why? Why not?");
            this.arrayRandom.add("Believe me there are 1000 reasons and excuses to justify your inaction.");
            this.arrayRandom.add("Your academic results don;t matter. Trust me and ask life results and achievements.");
            this.arrayRandom.add("Okay life knocked you down. So what? Will you just stay there in that dust, or get up and try again.");
            this.arrayRandom.add("If you are waiting for your parents to support you. They might be so ancient in their thinking that they don't understand this opportunity that you have.");
            this.arrayRandom.add("Life is like this.  \n I like THIS.");
            this.arrayRandom.add("");
            this.arrayRandom.add("Don't allow other people's opinion of you drown down your own voice.");
            this.arrayRandom.add("While you were waking up today, someone else was taking their last breath. \n Be thankful for this day. \n Don't waste it.");
            this.arrayRandom.add("Go confidently in the direction of your dreams. Live the life you have imagined.");
            this.arrayRandom.add("The only person you are destined to become is the person you become to be.");
            this.arrayRandom.add("Obstacles are those frightful things you see when you take your eyes off the goal.");
            this.arrayRandom.add("Inspiration exists, but must find you working.");
            this.arrayRandom.add("The most common way people give up their power is by thinking they don't have any.");
            this.arrayRandom.add("You can never cross the ocean until you have the courage to lose sight of the shore.");
            this.arrayRandom.add("Don't judge each day by the harvest you reap, but by the seeds you plant.");
            this.arrayRandom.add("It's important to have specific dreams. \n Dream Big. Dream without fear.");
            this.arrayRandom.add("Don't wait. The time will never be just right.");
            this.arrayRandom.add("Don't be afraid to give up the good to go for the great.");
            this.arrayRandom.add("Be an opener of doors.");
            this.arrayRandom.add("Courage is resistance to fear, mastery of fear, not absence of fear.");
            this.arrayRandom.add("Your legacy is been written by yourself. Make the right decisions.");
            this.arrayRandom.add("Be your unapologetically weird self.");
            this.arrayRandom.add("Success is what you attract by the person you become.");
            this.arrayRandom.add("Success is the sum of small efforts, repeated day-in and day-out.");
            this.arrayRandom.add("It's always the start that requires the greatest effort.");
            this.arrayRandom.add("Life is either a daring adventure or nothing.");
            this.arrayRandom.add("Act ad if what you do makes a difference. It does.");
            this.arrayRandom.add("It's not what we do once in a while that shapes our lives. It's what we do consistently.");
            this.arrayRandom.add("Your time is limited, so don't waste it living someone else's life.");
            this.arrayRandom.add("Success is getting what you want, happiness is wanting what you get.");
            this.arrayRandom.add("Show me a person who never made a mistake and I will show you a person who never did anything.");
            this.arrayRandom.add("I knew that if I failed I wouldn't regret that, but I knew the one thing I might regret is not trying.");
            this.arrayRandom.add("The world makes way for the man who knows where he is going.");
            this.arrayRandom.add("I'm not a product of my circumstances. I am a product of my decisions.");
            this.arrayRandom.add("Some people dream of success. While others wake uo and grind.");
            this.arrayRandom.add("Motivation is what gets you started. Habit is what keeps you going.");
            this.arrayRandom.add("Develop success from failures. \n Discouragement and failure are two of the surest stepping atones to success.");
            this.arrayRandom.add("Confidence comes not from always being right but not fearing to be wrong.");
            this.arrayRandom.add("Success is liking yourself, liking what you do, and liking how you do it.");
            this.arrayRandom.add("Without action, knowledge is often meaningless.");
            this.arrayRandom.add("All progress takes place outside the comfort zone.");
            this.arrayRandom.add("Success isn't just about what you accomplish in your life; it's about what you inspire others to do.");
            this.arrayRandom.add("The most wasted of all days is one without laughter.");
            this.arrayRandom.add("When I let go of what I am, I become what I might be.");
            this.arrayRandom.add("Life is not about finding yourself. Life is about creating yourself.");
            this.arrayRandom.add("Success is not in what you have, but who you are.");
            this.arrayRandom.add("Don't worry about failure; you only have to be right once.");
            this.arrayRandom.add("The fastest way to change yourself is to hang out with people who are already the way you want to be.");
            this.arrayRandom.add("The important thing is never to stop questioning.");
            this.arrayRandom.add("I haven't failed, I've found 10,000 ways that don't work.");
            this.arrayRandom.add("Whenever you find yourself in the majority, it is time to pause and reflect.");
            this.arrayRandom.add("It is better to fail in originality than to succeed in imitation.");
            this.arrayRandom.add("Successful people do what unsuccessful people are not willing to do. Don't wish it were easier; wish you were better.");
            this.arrayRandom.add("Do one thing everyday that scares you.");
            this.arrayRandom.add("Don't let the fear of losing be greater than the excitement of winning.");
            this.arrayRandom.add("The only limit to our realization of tomorrow will be our doubts of today.");
            this.arrayRandom.add("It's okay to be discouraged. It's not okay to quit.");
            this.arrayRandom.add("For better or worse, our future will be determined in large part by our dreams and by the struggle to make them real.");
            this.arrayRandom.add("Our imagination is the only limit to what we can hope to have in the future.");
            this.arrayRandom.add("Your only limitations are those you set up in your mind, or permit others to set up for you.");
            this.arrayRandom.add("I cannot give you the formula for success, but  can give you the formula for failure \n It is: Try to please everybody.");
            this.arrayRandom.add("Don't let people talk you into what they think is you.");
            this.arrayRandom.add("First they ignore you, then they laugh at you, then they fight you, then you win.");
            this.arrayRandom.add("There's no shortage of remarkable ideas, what's missing is the will to execute them.");
            this.arrayRandom.add("A calm sea does not make a skilled sailor.");
            this.arrayRandom.add("Do what you can, where you are, with what you have.");
            this.arrayRandom.add("If you don't like something, change it. If you can't change it, change your attitude. Don't complain.");
            this.arrayRandom.add("Successful people are the ones who are breaking the rules.");
            this.arrayRandom.add("If you care about what you do and work hard at it, there isn't anything you can't do if you want to.");
            this.arrayRandom.add("You must expect great things of yourself before you can do them.");
            this.arrayRandom.add("The road to success is dotted with many tempting parking spaces.");
            this.arrayRandom.add("The merits of all things lies in their difficulty.");
            this.arrayRandom.add("If I cannot do great things. I can do small things in a great way.");
            this.arrayRandom.add("No matter how good you get you can always get better, and that's the exciting part.");
            this.arrayRandom.add("The man who moves a mountain begins by carrying away small stones.");
            this.arrayRandom.add("Necessity is the mother of taking chances.");
            this.arrayRandom.add("Those that will fly tomorrow are already running today");
            this.arrayRandom.add("You are here to enable the divine purpose of the universe to unfold. That's how important you are!");
            this.arrayRandom.add("Don't wish it were easier. Wish you were better.");
            this.arrayRandom.add("The only way of finding the limits of the possible is by going beyond them into the impossible.");
            this.arrayRandom.add("Work Hard in Silence, Let success make the Noise!");
            this.arrayRandom.add("Do it for the people who want to see you fail.");
            this.arrayRandom.add("Stop focusing on how stressed you are and remember how blessed you are.");
            this.arrayRandom.add("Don't be afraid to fail. Be afraid not to try.");
            this.arrayRandom.add("Work until you no longer have to  introduce yourself.");
            this.arrayRandom.add("I already know what giving up feels like. \n I want to see what happens if I don't");
            this.arrayRandom.add("Create a vision that makes you wanna jump out of bed in the morning.");
            this.arrayRandom.add("Slow progress is better than no progress.");
            this.arrayRandom.add("Sometimes people with the worst pasts end up creating the best futures.");
            this.arrayRandom.add("The greatest pleasure in life is doing what people say you cannot do");
            this.arrayRandom.add("I want to inspire people. I want someone to look at me and say \n 'Because of you I didn't give up.'");
            this.arrayRandom.add("Learn to say 'no' without explaining yourself.");
            this.arrayRandom.add("Never stop doing your best just because someone doesn't give you credit.");
            this.arrayRandom.add("Someday, everything will make perfect sense. So for now, laugh at the confusion, smile through the tears, and keep reminding yourself that everything happens for a reason.");
            this.arrayRandom.add("Be what you want to be not what others want to see.");
            this.arrayRandom.add("All things are difficult before they are easy.");
            this.arrayRandom.add("The expert in anything was once a beginner.");
            this.arrayRandom.add("There will be haters, there will be doubters, there will be non-believers, and there will be you. Proving them wrong.");
            this.arrayRandom.add("forget all the reasons why it won't work and believe the one reason why it will.");
            this.arrayRandom.add("Your hardest times often lead to the greatest moments of your life. Keep the faith. It will all be worth it in the end.");
            this.arrayRandom.add("Yes I have made mistakes. A tonne of the. Life didn't come with instructions.");
            this.arrayRandom.add("Be happy it drives people crazy.");
            this.arrayRandom.add("Always remember to fall asleep with a dream and wake up with a purpose.");
            this.arrayRandom.add("Be stubborn about your goals. Flexible about your methods.");
            this.arrayRandom.add("I always wondered why somebody didn't do something about that, then I realized I am somebody.");
            this.arrayRandom.add("If you don't run your own life, somebody else will.");

        PasswordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clearAllPin.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable no) {

                if (no.length()==0) {
                    reporterPassword.setText("" + "Not Entered" + "");
                    clearAllPin.setVisibility(View.INVISIBLE);
                }
                else if (no.length()<4)
                    reporterPassword.setText("" + "Short" + "");
                if (no.length()==4)
                    reporterPassword.setText("" + "Max Length" + "");
            }
        });

        UsernameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clearAllUsername.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable no) {
                if (no.length()==0) {
                    reporterUsername.setText("" + "Not Entered" + "");
                    clearAllUsername.setVisibility(View.INVISIBLE);
                }
                if (no.length()>0)
                    reporterUsername.setText(" ");
            }
        });

        clearAllUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {UsernameField.getText().clear();
            }
        });

        clearAllPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PasswordField.getText().clear();
            }
        });


    }

    public void AccessifCorrect(View view) {

        String[] weddingRing = getIntent().getStringArrayExtra("diamond");
        final Parcelable[] parcel = getIntent().getParcelableArrayExtra("selectedItems");

        final Button button = (Button) findViewById(R.id.loginbutton);

        Animation animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(1000);
        button.startAnimation(animation);

        final String UsernameContent = UsernameField.getText().toString();
        final String UsernameString = UsernameContent.substring(UsernameContent.indexOf(".")+1);
        final String UserName = UsernameString.substring(0,1).toUpperCase() + UsernameString.substring(1).toLowerCase();

        if (UsernameField.getText().toString().equals("admin") && PasswordField.getText().toString().equals("1234")) {

            LucidApplication app = LucidApplication.getInstance();
            app.prev.clear();
            app.allinfoodcounter = 0;

            StyleableToast VeriefiedKorQ = new StyleableToast(LoginActivity.this, "Welcome " + UsernameField.getText().toString(), Toast.LENGTH_SHORT).spinIcon();
            VeriefiedKorQ.setBackgroundColor(Color.parseColor("#FF5A5F"));
            VeriefiedKorQ.setTextColor(Color.WHITE);
            VeriefiedKorQ.show();

            Intent outTent = new Intent(getApplicationContext(), FoodmenuActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("king", UsernameField.getText().toString());
            outTent.putExtra("selectedItems", parcel);
            outTent.putExtra("diamond", weddingRing);
            outTent.putExtras(bundle);
            startActivity(outTent);
            finish();

        } else if (UsernameField.getText().toString().isEmpty() && PasswordField.getText().toString().isEmpty()) {

           final AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this); //this is very important
           builder.setTitle("Heyy...Friend...");
           builder.setMessage("Trust me I understand...but kindly fill up those spaces first.");
           builder.setIcon(R.drawable.a_alert);
           builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   dialog.dismiss();
               }
           });
           Dialog dialog = builder.create();
           dialog.show();

            StyleableToast EmptyFields = new StyleableToast(this, "Please enter your Credentials", Toast.LENGTH_SHORT).spinIcon();
            EmptyFields.setBackgroundColor(Color.parseColor("#FF5A5F"));
            EmptyFields.setTextColor(Color.WHITE);
            EmptyFields.show();
        } else if (UsernameField.getText().toString().isEmpty()) {
            StyleableToast EmptyField = new StyleableToast(this, "Please enter your Username", Toast.LENGTH_SHORT).spinIcon();
            EmptyField.setBackgroundColor(Color.parseColor("#FF5A5F"));
            EmptyField.setTextColor(Color.WHITE);
            EmptyField.show();
        } else if (PasswordField.getText().toString().isEmpty()) {
            StyleableToast EmptyField = new StyleableToast(this, "Please enter your Password", Toast.LENGTH_SHORT).spinIcon();
            EmptyField.setBackgroundColor(Color.parseColor("#FF5A5F"));
            EmptyField.setTextColor(Color.WHITE);
            EmptyField.show();
        }
        else {

            LucidApplication app = LucidApplication.getInstance();
            app.prev.clear();
            app.allinfoodcounter = 0;

            StringRequest stringRequest = new StringRequest(Request.Method.POST, turnUp_url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            String[] engagementRing = getIntent().getStringArrayExtra("diamond");

                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                JSONObject jsonObject = jsonArray.getJSONObject(0);
                                String code = jsonObject.getString("code");
                                switch (code) {
                                    case "login_failed":
                                        quantumElevation.setTitle("There's a mismatch somewhere");
                                        exhibitElevation(jsonObject.getString("message"));
                                        break;
                                    case "short_balance":
                                        quantumElevation.setTitle("Short Balance");
                                        exhibitElevation(jsonObject.getString("short_balance_message"));
                                        break;
                                    default:
                                        Intent serverTent = new Intent(LoginActivity.this, FoodmenuActivity.class);
                                        Bundle ICDAT = new Bundle();
                                        ICDAT.putString("name", jsonObject.getString("name"));
                                        ICDAT.putString("email", jsonObject.getString("email"));
                                        ICDAT.putString("accountbalance", jsonObject.getString("accountbalance"));
                                        ICDAT.putString("image", jsonObject.getString("image"));
                                        ICDAT.putString("king", UserName);
                                        ICDAT.putString("kingDavid", UsernameContent);
                                        serverTent.putExtra("diamond", engagementRing);
                                        StyleableToast VeriefiedKorQ = new StyleableToast(LoginActivity.this, "Welcome " + UserName, Toast.LENGTH_SHORT).spinIcon();
                                        VeriefiedKorQ.setBackgroundColor(Color.parseColor("#FF5A5F"));
                                        VeriefiedKorQ.setTextColor(Color.WHITE);
                                        VeriefiedKorQ.show();
                                        serverTent.putExtras(ICDAT);
                                        startActivity(serverTent);
                                        break;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    try {
                        AlertDialog.Builder weightBuilder = new AlertDialog.Builder(LoginActivity.this);
                        weightBuilder.setTitle("Connection disconnected");
                        weightBuilder.setMessage("You can do it. \n Swipe down from the very top and restart the wifi from its icon");
                        weightBuilder.setIcon(R.drawable.a_alert);
                        weightBuilder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        weightBuilder.create().show();
                        error.printStackTrace();
                    }catch (Exception ignored) {

                    }
                }
            })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> param = new HashMap<>();
                    param.put("user_name", UsernameField.getText().toString());
                    param.put("password", PasswordField.getText().toString());
                    return param;
                }
            };
            MyCountlesston.getmInstance(LoginActivity.this).addToRequestQueue(stringRequest);
        }

    }

    public void exhibitElevation(String ping) {
        quantumElevation.setMessage(ping);
        quantumElevation.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UsernameField.setText("");
                PasswordField.setText("");
            }
        });
        AlertDialog alertDialog = quantumElevation.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Unnecessary Move");
        alertDialog.setMessage("This action is prevented and unnecessary");
        alertDialog.setIcon(R.drawable.a_alert);
        alertDialog.setNeutralButton("   ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(LoginActivity.this, VendorActivity.class);
                startActivity(intent);
             }
        });
        alertDialog.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.create().show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.intRandom = new Random().nextInt(45);
         if (actuallyTime.getText().toString().contentEquals("2017 - 11 - 27"))
             this.textRandom.setText("" + "Happy Birthday Dweezy" + "");
        else if (actuallyTime.getText().toString().contentEquals("2017 - 06 - 25"))
             this.textRandom.setText("" + "Happy Third Day Dweezy" + "");
        else
        this.textRandom.setText(this.arrayRandom.get(this.intRandom));
        Log.d("LoginActivity","onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LoginActivity","onResume invoked");
        wakeLock.acquire();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LoginActivity","onPause invoked");
        wakeLock.release();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LoginActivity","onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LoginActivity","onDestroy invoked");
    }

}
